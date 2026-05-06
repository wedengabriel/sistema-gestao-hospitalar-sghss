package com.sghss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghss.backend.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}