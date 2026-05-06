package com.sghss.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProntuario;

    @OneToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @Column(name = "prescricao_digital")
    private String prescricaoDigital;

    @Column(name = "descricao_clinica")
    private String descricaoClinica;

    // GETTERS E SETTERS

    public Integer getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Integer idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getPrescricaoDigital() {
        return prescricaoDigital;
    }

    public void setPrescricaoDigital(String prescricaoDigital) {
        this.prescricaoDigital = prescricaoDigital;
    }

    public String getDescricaoClinica() {
        return descricaoClinica;
    }

    public void setDescricaoClinica(String descricaoClinica) {
        this.descricaoClinica = descricaoClinica;
    }
}