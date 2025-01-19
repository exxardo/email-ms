package com.ms.email_ms.models;

import com.ms.email_ms.enums.StatusEmail;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe que representa a entidade Email.
 * Contém as informações necessárias para o envio e rastreamento de e-mails no sistema.
 */
@Entity
@Table(name = "tb_email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    // Identificador único do e-mail, gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Identificador único do usuário associado ao e-mail
    private UUID userId;

    // Endereço de e-mail do remetente
    private String emailFrom;

    // Endereço de e-mail do destinatário
    private String emailUser;

    // Assunto do e-mail
    private String subject;

    // Conteúdo da mensagem do e-mail, armazenado como texto longo
    @Column(columnDefinition = "TEXT")
    private String message;

    // Data e hora em que o e-mail foi enviado
    private LocalDateTime sendDate;

    // Status do envio do e-mail (Enum: SUCESSO ou ERRO)
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;

    /**
     * Obtém o identificador único do e-mail.
     *
     * @return UUID do e-mail.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Define o identificador único do e-mail.
     *
     * @param id UUID a ser atribuído ao e-mail.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Obtém o identificador único do usuário associado ao e-mail.
     *
     * @return UUID do usuário.
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Define o identificador único do usuário associado ao e-mail.
     *
     * @param userId UUID do usuário a ser associado.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Obtém o endereço de e-mail do remetente.
     *
     * @return Endereço de e-mail do remetente.
     */
    public String getEmailFrom() {
        return emailFrom;
    }

    /**
     * Define o endereço de e-mail do remetente.
     *
     * @param emailFrom Endereço de e-mail a ser atribuído ao remetente.
     */
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    /**
     * Obtém o endereço de e-mail do destinatário.
     *
     * @return Endereço de e-mail do destinatário.
     */
    public String getEmailUser() {
        return emailUser;
    }

    /**
     * Define o endereço de e-mail do destinatário.
     *
     * @param emailUser Endereço de e-mail a ser atribuído ao destinatário.
     */
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    /**
     * Obtém o assunto do e-mail.
     *
     * @return Assunto do e-mail.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Define o assunto do e-mail.
     *
     * @param subject Assunto a ser atribuído ao e-mail.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Obtém o conteúdo da mensagem do e-mail.
     *
     * @return Conteúdo da mensagem.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define o conteúdo da mensagem do e-mail.
     *
     * @param message Conteúdo da mensagem a ser atribuído ao e-mail.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtém a data e hora em que o e-mail foi enviado.
     *
     * @return Data e hora de envio.
     */
    public LocalDateTime getSendDate() {
        return sendDate;
    }

    /**
     * Define a data e hora em que o e-mail foi enviado.
     *
     * @param sendDate Data e hora a serem atribuídas ao envio.
     */
    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * Obtém o status do envio do e-mail (SUCESSO ou ERRO).
     *
     * @return Status do envio (Enum StatusEmail).
     */
    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    /**
     * Define o status do envio do e-mail (SUCESSO ou ERRO).
     *
     * @param statusEmail Status a ser atribuído ao envio (Enum StatusEmail).
     */
    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
