package com.ms.email_ms.repositories;

import com.ms.email_ms.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repositório responsável por realizar operações de persistência para a entidade Email.
 * Extende JpaRepository para fornecer métodos prontos para operações de CRUD e consultas personalizadas.
 */
public interface EmailRepository extends JpaRepository<Email, UUID> {
}