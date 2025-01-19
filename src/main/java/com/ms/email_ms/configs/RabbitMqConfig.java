package com.ms.email_ms.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração do RabbitMQ.
 * Configura a fila de e-mails e o conversor de mensagens para JSON.
 */
@Configuration
public class RabbitMqConfig {

    // Nome da fila de e-mail, injetado a partir do arquivo de configuração
    @Value("${broker.queue.email.name}")
    private String queueEmail;

    /**
     * Criação da fila de e-mail com parâmetro de durabilidade definido como true.
     * Isso garante que a fila persista mesmo que o RabbitMQ seja reiniciado.
     *
     * @return Instância da fila configurada.
     */
    @Bean
    public Queue queueEmail() {
        return new Queue(queueEmail, true);
    }

    /**
     * Configuração do conversor de mensagens para JSON utilizando Jackson.
     * Permite que as mensagens sejam serializadas e desserializadas automaticamente no formato JSON.
     *
     * @return Instância do Jackson2JsonMessageConverter configurada.
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
