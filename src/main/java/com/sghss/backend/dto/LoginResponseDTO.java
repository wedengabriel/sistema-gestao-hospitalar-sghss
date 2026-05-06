package com.sghss.backend.dto;

public class LoginResponseDTO {

    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}