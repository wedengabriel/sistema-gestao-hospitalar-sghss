package com.sghss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sghss.backend.dto.MedicoCreateDTO;
import com.sghss.backend.dto.MedicoDTO;
import com.sghss.backend.dto.UsuarioDTO;
import com.sghss.backend.entity.Medico;
import com.sghss.backend.entity.Usuario;
import com.sghss.backend.repository.MedicoRepository;
import com.sghss.backend.repository.UsuarioRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final UsuarioRepository usuarioRepository;

    public MedicoService(
            MedicoRepository medicoRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.medicoRepository = medicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public MedicoDTO criarMedico(MedicoCreateDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Medico medico = new Medico();

        medico.setUsuario(usuario);
        medico.setRegistroProfissional(dto.getRegistroProfissional());
        medico.setEspecialidade(dto.getEspecialidade());

        Medico medicoSalvo = medicoRepository.save(medico);

        return converterParaDTO(medicoSalvo);
    }

    public List<MedicoDTO> listarMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public MedicoDTO buscarPorId(Integer id) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        return converterParaDTO(medico);
    }

    public void deletarMedico(Integer id) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        medicoRepository.delete(medico);
    }

    private MedicoDTO converterParaDTO(Medico medico) {

        MedicoDTO dto = new MedicoDTO();

        dto.setIdMedico(medico.getIdMedico());
        dto.setRegistroProfissional(medico.getRegistroProfissional());
        dto.setEspecialidade(medico.getEspecialidade());

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(medico.getUsuario().getIdUsuario());
        usuarioDTO.setNomeUsuario(medico.getUsuario().getNomeUsuario());
        usuarioDTO.setCpf(medico.getUsuario().getCpf());

        if (medico.getUsuario().getPerfil() != null) {
            usuarioDTO.setIdPerfil(medico.getUsuario().getPerfil().getIdPerfil());
        }

        dto.setUsuario(usuarioDTO);

        return dto;
    }
}