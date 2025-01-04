package com.java.bms.Controller;

import com.java.bms.Jwt.JwtUtil;
import com.java.bms.Model.User;
import com.java.bms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/google")
public class AuthController {

    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<?> googleAuthRedirect() {
        String redirectUri = "http://localhost:8080/api/auth/google/callback";
        String clientId = System.getenv("GOOGLE_CLIENT_ID");
        String url = String.format(
                "https://accounts.google.com/o/oauth2/v2/auth?client_id=%s&redirect_uri=%s&response_type=code&scope=email profile",
                clientId, redirectUri
        );
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", url).build();
    }

    @PostMapping("/callback")
    public ResponseEntity<?> handleCallback(@RequestParam("code") String code) {
        try {
            // Step 1: Exchange the authorization code for tokens
            RestTemplate restTemplate = new RestTemplate();
            String redirectUri = "http://localhost:8080/api/auth/google/callback";
            String clientId = System.getenv("GOOGLE_CLIENT_ID");
            String clientSecret = System.getenv("GOOGLE_CLIENT_SECRET");

            Map<String, String> tokenRequest = new HashMap<>();
            tokenRequest.put("code", code);
            tokenRequest.put("client_id", clientId);
            tokenRequest.put("client_secret", clientSecret);
            tokenRequest.put("redirect_uri", redirectUri);
            tokenRequest.put("grant_type", "authorization_code");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(tokenRequest, headers);

            String GOOGLE_TOKEN_ENDPOINT = "https://oauth2.googleapis.com/token";
            ResponseEntity<Map> tokenResponse = restTemplate.exchange(
                    GOOGLE_TOKEN_ENDPOINT, HttpMethod.POST, entity, Map.class);

            if (!tokenResponse.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.status(tokenResponse.getStatusCode())
                        .body("Failed to fetch tokens from Google");
            }

            Map<String, Object> tokenData = tokenResponse.getBody();
            String idToken = (String) tokenData.get("id_token");
            String accessToken = (String) tokenData.get("access_token");

            // Step 2: Fetch user information
            HttpHeaders userInfoHeaders = new HttpHeaders();
            userInfoHeaders.setBearerAuth(accessToken);

            HttpEntity<String> userInfoEntity = new HttpEntity<>(userInfoHeaders);
            String GOOGLE_USERINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json";
            ResponseEntity<Map> userInfoResponse = restTemplate.exchange(
                    GOOGLE_USERINFO_ENDPOINT, HttpMethod.GET, userInfoEntity, Map.class);

            if (!userInfoResponse.getStatusCode().is2xxSuccessful()) {
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

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during Google authentication");
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
