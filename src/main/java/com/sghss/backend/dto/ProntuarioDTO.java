package com.sghss.backend.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProntuarioDTO {

    private Integer idProntuario;
    private String prescricaoDigital;
    private String descricaoClinica;
    private LocalDateTime dataAtualizacao;
}