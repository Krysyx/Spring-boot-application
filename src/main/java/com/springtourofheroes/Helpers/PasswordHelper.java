package com.springtourofheroes.Helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHelper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean compare(String password, String confirmpassword) {
        return password.equals(confirmpassword);
    }

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
