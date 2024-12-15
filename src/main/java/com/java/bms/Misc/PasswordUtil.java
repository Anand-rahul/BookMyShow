package com.java.bms.Misc;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class PasswordUtil {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Encrypt the password
    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Verify raw password with encrypted password
    public boolean matchPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }
}
