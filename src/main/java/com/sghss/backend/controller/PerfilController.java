package com.sghss.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghss.backend.dto.PerfilDTO;
import com.sghss.backend.service.PerfilService;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    public PerfilDTO criarPerfil(@RequestBody PerfilDTO dto) {
        return perfilService.criarPerfil(dto);
    }

    @GetMapping
    public List<PerfilDTO> listarPerfis() {
        return perfilService.listarPerfis();
    }

    @GetMapping("/{id}")
    public PerfilDTO buscarPorId(@PathVariable Integer id) {
        return perfilService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPerfil(@PathVariable Integer id) {
        perfilService.deletarPerfil(id);
    }
}