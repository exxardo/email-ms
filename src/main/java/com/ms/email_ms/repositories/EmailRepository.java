package com.ms.email_ms.repositories;

import com.ms.email_ms.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository  extends JpaRepository<Email, UUID> {


}
