package com.sghss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghss.backend.entity.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {
}