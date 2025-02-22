package com.diplom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tokens {
    @Getter
    private static String accessToken;
    private static String refreshToken;

    public static void setAccessToken(String accessToken) {
        Tokens.accessToken = accessToken;
    }

    public static void setRefreshToken(String refreshToken) {
        Tokens.refreshToken = refreshToken;
    }
}