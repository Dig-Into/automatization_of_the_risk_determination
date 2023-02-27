package com.aord.aord.dto;

import javax.validation.constraints.NotNull;

public class LoginResponseDTO {

    @NotNull
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public LoginResponseDTO(@NotNull String jwt) {
        this.jwt = jwt;
    }

}