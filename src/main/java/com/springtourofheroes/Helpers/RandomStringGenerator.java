package com.springtourofheroes.Helpers;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomStringGenerator {
    public static String generateString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
