package com.sghss.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioUpdateDTO {

    @NotBlank
    private String nomeUsuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}