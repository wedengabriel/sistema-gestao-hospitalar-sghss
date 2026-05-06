package com.sghss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sghss.backend.dto.PacienteCreateDTO;
import com.sghss.backend.dto.PacienteDTO;
import com.sghss.backend.dto.UsuarioDTO;
import com.sghss.backend.entity.Paciente;
import com.sghss.backend.entity.Usuario;
import com.sghss.backend.repository.PacienteRepository;
import com.sghss.backend.repository.UsuarioRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    public PacienteService(
            PacienteRepository pacienteRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PacienteDTO criarPaciente(PacienteCreateDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Paciente paciente = new Paciente();

        paciente.setUsuario(usuario);
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setTipoSanguineo(dto.getTipoSanguineo());

        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        return converterParaDTO(pacienteSalvo);
    }

    public List<PacienteDTO> listarPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public PacienteDTO buscarPorId(Integer id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return converterParaDTO(paciente);
    }

    public void deletarPaciente(Integer id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteRepository.delete(paciente);
    }

    private PacienteDTO converterParaDTO(Paciente paciente) {

        PacienteDTO dto = new PacienteDTO();

        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setDataNascimento(paciente.getDataNascimento());
        dto.setTipoSanguineo(paciente.getTipoSanguineo());

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(
                paciente.getUsuario().getIdUsuario()
        );

        usuarioDTO.setNomeUsuario(
                paciente.getUsuario().getNomeUsuario()
        );

        usuarioDTO.setCpf(
                paciente.getUsuario().getCpf()
        );

        if (paciente.getUsuario().getPerfil() != null) {

            usuarioDTO.setIdPerfil(
                    paciente.getUsuario().getPerfil().getIdPerfil()
            );
        }

        dto.setUsuario(usuarioDTO);

        return dto;
    }
}