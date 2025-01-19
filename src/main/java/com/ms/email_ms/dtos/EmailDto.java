package com.ms.email_ms.dtos;

import java.util.UUID;

/**
 * DTO que representa os dados necessários para o envio de um e-mail.
 * Contém informações como o ID do usuário, endereço de e-mail do destinatário, assunto e mensagem.
 *
 * @param userId    Identificador único do usuário associado ao e-mail.
 * @param emailUser Endereço de e-mail do destinatário.
 * @param subject   Assunto do e-mail.
 * @param message   Mensagem do e-mail.
 */
public record EmailDto(UUID userId, String emailUser, String subject, String message) {

}