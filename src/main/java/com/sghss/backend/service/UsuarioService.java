package com.sghss.backend.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sghss.backend.dto.UsuarioCreateDTO;
import com.sghss.backend.dto.UsuarioDTO;
import com.sghss.backend.dto.UsuarioUpdateDTO;
import com.sghss.backend.entity.Perfil;
import com.sghss.backend.entity.Usuario;
import com.sghss.backend.repository.PerfilRepository;
import com.sghss.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PerfilRepository perfilRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO criarUsuario(UsuarioCreateDTO dto) {

        Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setCpf(dto.getCpf());

        String senhaCriptografada = passwordEncoder.encode(dto.getSenhaHash());
        usuario.setSenhaHash(senhaCriptografada);

        usuario.setPerfil(perfil);
        usuario.setUsuarioAtivo(true);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return converterParaDTO(usuarioSalvo);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public UsuarioDTO buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return converterParaDTO(usuario);
    }

    public UsuarioDTO atualizarUsuario(Integer id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNomeUsuario(dto.getNomeUsuario());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return converterParaDTO(usuarioAtualizado);
    }

    public void deletarUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNomeUsuario(usuario.getNomeUsuario());
        dto.setCpf(usuario.getCpf());

        if (usuario.getPerfil() != null) {
            dto.setIdPerfil(usuario.getPerfil().getIdPerfil());
        }

        return dto;
    }
}