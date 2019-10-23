package com.wangmin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil extends BCryptPasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoderUtil be = new BCryptPasswordEncoderUtil();
        String encode = be.encode("123");
        System.out.println(encode);
    }
}
