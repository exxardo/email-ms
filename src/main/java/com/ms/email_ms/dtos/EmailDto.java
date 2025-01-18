package com.ms.email_ms.dtos;

import java.util.UUID;

public record EmailDto(UUID userId, String emailUser, String subject, String message) {

}
