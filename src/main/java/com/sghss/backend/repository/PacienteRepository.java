package com.sghss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghss.backend.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}