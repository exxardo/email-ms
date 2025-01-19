package com.ms.email_ms.consumers;

import com.ms.email_ms.dtos.EmailDto;
import com.ms.email_ms.services.EmailService;
import com.ms.email_ms.models.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por consumir mensagens da fila de e-mails no RabbitMQ.
 * Processa as mensagens recebidas, converte os dados para a entidade Email e delega o envio para o serviço de e-mail.
 */
@Component
public class EmailConsumer {

    // Serviço responsável por enviar os e-mails
    final EmailService emailService;

    /**
     * Construtor com injeção de dependência do EmailService.
     *
     * @param emailService Serviço de envio de e-mails.
     */
    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Método que escuta a fila de e-mails configurada no RabbitMQ.
     * Recebe mensagens, converte os dados do DTO para a entidade Email e delega o envio ao serviço.
     *
     * @param emailDto Objeto contendo os dados do e-mail recebidos da fila.
     */
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        // Cria uma nova instância da entidade Email
        var email = new Email();

        // Copia as propriedades do DTO para a entidade Email
        BeanUtils.copyProperties(emailDto, email);

        // Envia o e-mail utilizando o serviço de envio
        emailService.sendEmail(email);
    }
}


