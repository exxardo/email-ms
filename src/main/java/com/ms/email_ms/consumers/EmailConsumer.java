package com.ms.email_ms.consumers;

import com.ms.email_ms.dtos.EmailDto;
import com.ms.email_ms.services.EmailService;
import com.ms.email_ms.models.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Classe para consumir a fila de email
 */
@Component
public class EmailConsumer {

    final EmailService emailService;

    // Injeção de dependência do EmailService
    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    // Método para ouvir a fila de email
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        // Cria uma nova instância de Email
        var email = new Email();

        // Copia as propriedades do DTO para a entidade Email
        BeanUtils.copyProperties(emailDto, email);

        // Chama o método sendEmail com o objeto Email
        emailService.sendEmail(email);
    }
}
