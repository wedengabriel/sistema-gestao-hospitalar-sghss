package com.sghss.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghss.backend.dto.PacienteCreateDTO;
import com.sghss.backend.dto.PacienteDTO;
import com.sghss.backend.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public PacienteDTO criarPaciente(
            @RequestBody @Valid PacienteCreateDTO dto
    ) {
        return pacienteService.criarPaciente(dto);
    }

    @GetMapping
    public List<PacienteDTO> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Integer id) {
        return pacienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Integer id) {
        pacienteService.deletarPaciente(id);
    }
}