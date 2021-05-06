package com.springtourofheroes.Helpers;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordHelper {
    public boolean compare(String password, String confirmpassword) {
        return password.equals(confirmpassword);
    }
}
