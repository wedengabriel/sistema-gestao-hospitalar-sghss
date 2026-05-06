package com.sghss.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghss.backend.dto.MedicoCreateDTO;
import com.sghss.backend.dto.MedicoDTO;
import com.sghss.backend.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public MedicoDTO criarMedico(@RequestBody @Valid MedicoCreateDTO dto) {
        return medicoService.criarMedico(dto);
    }

    @GetMapping
    public List<MedicoDTO> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @GetMapping("/{id}")
    public MedicoDTO buscarPorId(@PathVariable Integer id) {
        return medicoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Integer id) {
        medicoService.deletarMedico(id);
    }
}