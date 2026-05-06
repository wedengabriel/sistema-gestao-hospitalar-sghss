package com.sghss.backend.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogAuditoriaDTO {

    private Integer idLog;
    private Integer idUsuario;
    private String acao;
    private LocalDateTime dataHora;
    private String ipOrigem;
}