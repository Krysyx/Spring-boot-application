package com.springtourofheroes.Helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
