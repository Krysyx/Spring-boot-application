package com.springtourofheroes.Helpers;

public class PasswordHelper {
    public static boolean compare(String password, String confirmpassword) {
        return password.equals(confirmpassword);
    }
}
