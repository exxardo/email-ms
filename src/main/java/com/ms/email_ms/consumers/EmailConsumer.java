package com.ms.email_ms.consumers;

import com.ms.email_ms.dtos.EmailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Classe para consumir a fila de email
 */
@Component
public class EmailConsumer {

    // Método para ouvir a fila de email
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        System.out.println(emailDto.emailUser());
    }
}
