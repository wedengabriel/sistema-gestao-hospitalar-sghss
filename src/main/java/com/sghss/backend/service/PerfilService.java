package com.sghss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sghss.backend.dto.PerfilDTO;
import com.sghss.backend.entity.Perfil;
import com.sghss.backend.repository.PerfilRepository;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public PerfilDTO criarPerfil(PerfilDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setNomePerfil(dto.getNomePerfil());

        Perfil salvo = perfilRepository.save(perfil);

        return converterParaDTO(salvo);
    }

    public List<PerfilDTO> listarPerfis() {
        return perfilRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public PerfilDTO buscarPorId(Integer id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        return converterParaDTO(perfil);
    }

    public void deletarPerfil(Integer id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        perfilRepository.delete(perfil);
    }

    private PerfilDTO converterParaDTO(Perfil perfil) {
        PerfilDTO dto = new PerfilDTO();
        dto.setIdPerfil(perfil.getIdPerfil());
        dto.setNomePerfil(perfil.getNomePerfil());
        return dto;
    }
}