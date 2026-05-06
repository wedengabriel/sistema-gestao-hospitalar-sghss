package com.sghss.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghss.backend.dto.ConsultaCreateDTO;
import com.sghss.backend.dto.ConsultaDTO;
import com.sghss.backend.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ConsultaDTO criarConsulta(@RequestBody @Valid ConsultaCreateDTO dto) {
        return consultaService.criarConsulta(dto);
    }

    @GetMapping
    public List<ConsultaDTO> listarConsultas() {
        return consultaService.listarConsultas();
    }

    @GetMapping("/{id}")
    public ConsultaDTO buscarPorId(@PathVariable Integer id) {
        return consultaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Integer id) {
        consultaService.deletarConsulta(id);
    }
}