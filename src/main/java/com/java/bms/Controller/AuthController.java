package com.java.bms.Controller;

import com.java.bms.Jwt.JwtUtil;
import com.java.bms.Model.User;
import com.java.bms.Repository.UserRepository;
import com.java.bms.Service.UserService;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Value("${google.client.id}") private String GOOGLE_CLIENT_ID;
    @Value("${google.client.secret}")private String GOOGLE_CLIENT_SECRET;
    private static final String GOOGLE_TOKEN_ENDPOINT = "https://oauth2.googleapis.com/token";
    private static final String GOOGLE_USERINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json";
    private static final String GOOGLE_REDIRECT_URI="http://localhost:8080/api/auth/google/callback";
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/google")
    public ResponseEntity<?> googleAuthRedirect() {
        String clientId = GOOGLE_CLIENT_ID;//System.getenv("GOOGLE_CLIENT_ID");
        String url = String.format(
                "https://accounts.google.com/o/oauth2/v2/auth?client_id=%s&redirect_uri=%s&response_type=code&scope=email profile",
                clientId, GOOGLE_REDIRECT_URI
        );
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", url).build();
    }

    @GetMapping("/google/callback")
    public ResponseEntity<?> handleCallback(@RequestParam("code") String code) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setMessageConverters(Arrays.asList(
                    new MappingJackson2HttpMessageConverter(),
                    new FormHttpMessageConverter()
            ));

            // Step 1: Exchange the authorization code for tokens
            MultiValueMap<String, String> tokenRequest = new LinkedMultiValueMap<>();
            tokenRequest.add("code", code);
            tokenRequest.add("client_id", GOOGLE_CLIENT_ID);
            tokenRequest.add("client_secret", GOOGLE_CLIENT_SECRET);
            tokenRequest.add("redirect_uri", GOOGLE_REDIRECT_URI);
            tokenRequest.add("grant_type", "authorization_code");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(tokenRequest, headers);

            ResponseEntity<Map> tokenResponse = restTemplate.exchange(
                    GOOGLE_TOKEN_ENDPOINT,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            if (!tokenResponse.getStatusCode().is2xxSuccessful()) {
                log.error("Token exchange failed: {}", tokenResponse);
                return ResponseEntity.status(tokenResponse.getStatusCode())
                        .body("Failed to fetch tokens from Google");
            }

            Map<String, Object> tokenData = tokenResponse.getBody();
            String accessToken = (String) tokenData.get("access_token");

            HttpHeaders userInfoHeaders = new HttpHeaders();
            userInfoHeaders.setBearerAuth(accessToken);
            userInfoHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> userInfoEntity = new HttpEntity<>(userInfoHeaders);
            ResponseEntity<Map> userInfoResponse = restTemplate.exchange(
                    GOOGLE_USERINFO_ENDPOINT,
                    HttpMethod.GET,
                    userInfoEntity,
                    Map.class
            );

            if (!userInfoResponse.getStatusCode().is2xxSuccessful()) {
                log.error("User info fetch failed: {}", userInfoResponse);
                return ResponseEntity.status(userInfoResponse.getStatusCode())
                        .body("Failed to fetch user info from Google");
            }

            Map<String, Object> userInfo = userInfoResponse.getBody();

            // Step 3: Generate JWT tokens
            Map<String, Object> claims = new HashMap<>();
            claims.put("userName", userInfo.get("name"));
            claims.put("email", userInfo.get("email"));

            String jwtToken = jwtUtil.generateToken(claims, (String) userInfo.get("id"));
            String refreshToken = jwtUtil.generateRefreshToken((String) userInfo.get("id"));

            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", jwtToken);
            response.put("refreshToken", refreshToken);
            response.put("user", userInfo);

            log.info("Successfully processed Google OAuth callback for user: {}", userInfo.get("email"));
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error during Google authentication", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during Google authentication: " + e.getMessage());
        }
    }
    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkAuthentication(@RequestHeader("Authorization") String authorizationHeader) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Extract and validate the token
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                response.put("isAuthenticated", false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
            if (!jwtUtil.validateToken(token)) {
                response.put("isAuthenticated", false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Extract user information
            String username = jwtUtil.extractUsername(token);
            User user = userService.fetchByUserName(username);

            if (user == null) {
                response.put("isAuthenticated", false);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Return success response
            response.put("isAuthenticated", true);
            Map<String, Object> userData = new HashMap<>();
            userData.put("id", user.id);
            userData.put("userName", user.userName);
            userData.put("email", user.emailId);
            response.put("user", userData);

            return ResponseEntity.ok(response);

        } catch (JwtException e) {
            response.put("isAuthenticated", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody Map<String, String> signInRequest) {
        try {
            String userName = signInRequest.get("userName");
            String password = signInRequest.get("password");

            // Fetch user by username
            User user = userService.fetchByUserName(userName);
            if (user == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            // Validate password
            boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());
            if (!isPasswordValid) {
                return ResponseEntity.status(401).body("Invalid password");
            }

            // Generate JWT token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("userName", user.getUserName());
            claims.put("email", user.getEmailId());

            String jwtToken = jwtUtil.generateToken(claims, String.valueOf(user.getId()));
            String refreshToken = jwtUtil.generateRefreshToken(String.valueOf(user.getId()));

            // Prepare response
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", jwtToken);
            response.put("refreshToken", refreshToken);
            response.put("user", user);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
