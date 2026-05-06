package com.sghss.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sghss.backend.dto.LoginRequestDTO;
import com.sghss.backend.dto.LoginResponseDTO;
import com.sghss.backend.entity.Usuario;
import com.sghss.backend.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = usuarioRepository.findByCpf(dto.getCpf())
                .orElseThrow(() -> new RuntimeException("CPF ou senha inválidos"));

        boolean senhaCorreta = passwordEncoder.matches(
                dto.getSenha(),
                usuario.getSenhaHash()
        );

        if (!senhaCorreta) {
            throw new RuntimeException("CPF ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuario.getCpf());

        return new LoginResponseDTO(token);
    }
}