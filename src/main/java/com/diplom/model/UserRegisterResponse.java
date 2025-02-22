package com.diplom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {
    private boolean success;
    private String accessToken;
    private String refreshToken;
    private User user;
}
