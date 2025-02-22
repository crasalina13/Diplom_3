package com.diplom;

import lombok.Getter;

@Getter
public enum Endpoints {
    BASE_URL("https://stellarburgers.nomoreparties.site/api/"),
    FORGOT_PASSWORD_PATH("https://stellarburgers.nomoreparties.site/forgot-password"),
    LOGIN_PATH("https://stellarburgers.nomoreparties.site/login"),
    MAIN_PATH("https://stellarburgers.nomoreparties.site"),
    REGISTER_PATH("https://stellarburgers.nomoreparties.site/register");

    private final String path;

    Endpoints(String path) {
        this.path = path;
    }
}
