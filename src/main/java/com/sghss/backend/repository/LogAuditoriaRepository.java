package com.sghss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghss.backend.entity.LogAuditoria;

public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Integer> {
}