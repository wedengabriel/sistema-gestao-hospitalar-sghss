package com.sghss.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDTO {

    private Integer idConsulta;
    private String dataConsulta;
    private String horaConsulta;
    private String tipoConsulta;
    private String status;
    private ProntuarioDTO prontuario;
}