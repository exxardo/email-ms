package com.ms.email_ms.dtos;

import java.util.UUID;

public record EmailDto(UUID id, String emailUser, String subject, String message) {

}
