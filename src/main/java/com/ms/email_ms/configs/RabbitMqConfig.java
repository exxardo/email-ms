package com.ms.email_ms.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração do RabbitMQ
 */
@Configuration
public class RabbitMqConfig {

    // Nome da fila de email
    @Value("${broker.queue.email.name}")
    private String queueEmail;

    // Criação da fila de email com paramentro de durabilidade true.
    @Bean
    public Queue queueEmail() {
        return new Queue(queueEmail, true);
    }

    // Configuração do conversor de mensagens.
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
    ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
