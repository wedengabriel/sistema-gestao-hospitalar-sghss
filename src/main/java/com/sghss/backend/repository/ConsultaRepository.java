package com.sghss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghss.backend.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}