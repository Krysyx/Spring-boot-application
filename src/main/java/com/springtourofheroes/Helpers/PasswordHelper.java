package com.springtourofheroes.Helpers;

import org.springframework.stereotype.Component;

@Component
public class PasswordHelper {
    public static boolean compare(String password, String confirmpassword) {
        return password.equals(confirmpassword);
    }
}
