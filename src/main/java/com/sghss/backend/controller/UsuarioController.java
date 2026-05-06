package com.sghss.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghss.backend.dto.UsuarioCreateDTO;
import com.sghss.backend.dto.UsuarioDTO;
import com.sghss.backend.dto.UsuarioUpdateDTO;
import com.sghss.backend.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody @Valid UsuarioCreateDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody @Valid UsuarioUpdateDTO dto
    ) {
        return usuarioService.atualizarUsuario(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
    }
}