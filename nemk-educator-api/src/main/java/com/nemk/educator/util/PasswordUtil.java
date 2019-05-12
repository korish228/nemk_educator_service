package com.nemk.educator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

//    @Autowired
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String getPasswordHash(String password) {
        return encoder.encode(password);
    }

}
