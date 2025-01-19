package com.ms.email_ms.services;

import com.ms.email_ms.enums.StatusEmail;
import com.ms.email_ms.models.Email;
import com.ms.email_ms.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Serviço responsável pelo envio de e-mails e pela persistência das informações relacionadas ao envio.
 * Gerencia a lógica de envio e rastreamento do status do e-mail (enviado ou falha).
 */
@Service
public class EmailService {

    // Repositório para operações de persistência da entidade Email
    final EmailRepository emailRepository;

    // Componente para envio de e-mails
    final JavaMailSender emailSender;

    /**
     * Construtor com injeção de dependência do EmailRepository e JavaMailSender.
     *
     * @param emailRepository Repositório para manipulação de dados do e-mail.
     * @param emailSender Componente responsável por enviar os e-mails.
     */
    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    // Endereço de e-mail do remetente, configurado no application.properties
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    /**
     * Envia um e-mail e salva as informações relacionadas ao envio no banco de dados.
     * Atualiza o status do envio para "SENT" em caso de sucesso ou "FAILED" em caso de erro.
     *
     * @param email Objeto contendo os dados do e-mail a ser enviado.
     * @return O objeto Email atualizado com o status do envio.
     */
    @Transactional
    public Email sendEmail(Email email) {
        try {
            // Define a data/hora de envio e o remetente
            email.setSendDate(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            // Cria a mensagem de e-mail
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailUser());
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());

            // Envia o e-mail utilizando o JavaMailSender
            emailSender.send(message);

            // Atualiza o status do envio para "SENT"
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            // Atualiza o status do envio para "FAILED" em caso de erro
            email.setStatusEmail(StatusEmail.FAILED);
        }

        // Salva as informações do envio no banco de dados
        return emailRepository.save(email);
    }
}

