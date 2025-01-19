# Email Microservice

### Esta é a segunda parte do projeto e é possível encontrar a primeira parte aqui: [User API](https://github.com/exxardo/user-api).

## Descrição

O **Email Microservice** é responsável por consumir mensagens publicadas no RabbitMQ e enviar e-mails utilizando SMTP. Ele também salva informações sobre os envios no banco de dados PostgreSQL.

---

## Problema Resolvido

Este projeto resolve o problema de envio de notificações por e-mail de forma assíncrona e escalável. Ele desacopla a lógica de envio de e-mails do sistema principal, garantindo que falhas no envio não impactem outras operações do sistema.

---

## Arquitetura do Sistema

Abaixo está a arquitetura geral do sistema, que inclui o **User API**, o **Email Microservice**, e a comunicação via RabbitMQ utilizando a CloudAMQP:

![Arquitetura do Sistema](https://pplx-res.cloudinary.com/image/upload/v1737252173/user_uploads/QGQLRkWouVvyrVD/image.jpg)

### Explicação da Arquitetura

- **User API**: Salva o usuário criado em um banco de dados PostgreeSQL e publica eventos relacionados aos usuários no RabbitMQ.
- **RabbitMQ**: Atua como um broker de mensagens, permitindo comunicação assíncrona entre os microsserviços.
- **Email Microservice**: Consome as mensagens publicadas pelo User API, envia notificações por e-mail e salva informações relacionadas a mensagem enviada em uma tabela no banco de dados PostgreeSQL.

Essa arquitetura foi escolhida por ser desacoplada, escalável e resiliente a falhas. O uso do RabbitMQ permite que os serviços funcionem de forma independente, garantindo maior disponibilidade.

---

## Funcionalidades

- **Consumo de Mensagens:** Escuta mensagens publicadas na fila do RabbitMQ.
- **Envio de E-mails:** Envia e-mails utilizando SMTP (Gmail).
- **Persistência:** Salva informações sobre os envios no banco de dados PostgreSQL.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **RabbitMQ** (CloudAMQP)
- **SMTP** (Gmail)
- **Maven**

---

## Configuração

### Pré-requisitos

- Java 17 instalado.
- PostgreSQL configurado.
- Conta na CloudAMQP para acesso ao RabbitMQ.
- Conta no Gmail configurada para envio de e-mails.

### Configuração do `application.properties`

No arquivo `src/main/resources/application.properties`, configure as seguintes propriedades:

```properties
server.port=8082
spring.datasource.url= jdbc:postgresql://localhost:5432/db_email
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.rabbitmq.addresses=URL BROKER
broker.queue.email.name=defaut.email
spring.mail.host=SMTP ESCOLHIDO
spring.mail.port=PORTA SMTP
spring.mail.username=EMAIL REMETENTE
spring.mail.password=SENHA GERADA
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## Como Executar

1. Clone o repositório:

   ```bash
   git clone <url-do-repositorio>
   cd email-ms
   ```

2. Compile e execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

3. O serviço estará escutando mensagens na fila configurada no RabbitMQ.

---

## Estrutura do Projeto

- `models/`: Contém as entidades do sistema.
- `consumers/`: Escuta mensagens da fila RabbitMQ.
- `services/`: Contém a lógica de envio de e-mails.
- `repositories/`: Gerencia a persistência no banco de dados.

---

## Padrões Adotados

1. **Arquitetura em Camadas**: O projeto segue uma separação clara entre camadas (Consumer, Service, Repository), garantindo modularidade e responsabilidade única.
2. **Comunicação Assíncrona**: Utilização do RabbitMQ para desacoplar os serviços, permitindo escalabilidade horizontal.
3. **DTOs (Data Transfer Objects)**: Uso de DTOs para transferir dados entre as camadas, garantindo encapsulamento e validações.

---

## Guia de Estilo

O projeto segue as boas práticas recomendadas pelo Java Code Conventions:
1. Nomes descritivos para classes, métodos e variáveis.
2. Uso consistente de indentação e espaçamento.
3. Documentação com comentários Javadoc em todas as classes públicas.

---

## Como Contribuir

1. Faça um fork deste repositório.
2. Crie uma branch com sua feature ou correção: `git checkout -b minha-feature`.
3. Commit suas alterações: `git commit -m 'Adiciona nova feature'`.
4. Envie para o repositório remoto: `git push origin minha-feature`.
5. Abra um Pull Request explicando suas alterações.

---

## Lições Aprendidas

Durante o desenvolvimento deste projeto, aprendemos:
1. A importância da comunicação assíncrona para sistemas distribuídos.
2. Como configurar e utilizar o RabbitMQ com Spring Boot.
3. Boas práticas na organização de microsserviços e integração com bancos de dados relacionais.

---

## Fontes Utilizadas para Consulta

- [DevMedia](https://www.devmedia.com.br/conheca-o-spring-transactional-annotations/32472)
- [Google Senhas](https://support.google.com/accounts/answer/185833)
- [CloudAMQP](https://www.cloudamqp.com/blog/part4-rabbitmq-for-beginners-exchanges-routing-keys-bindings.html)
- [Spring Boot](https://docs.spring.io/spring-boot/index.html)

---

## Contato

Para dúvidas ou sugestões, entre em contato através do meu [LinkedIn](https://www.linkedin.com/in/eduardoramiro).
