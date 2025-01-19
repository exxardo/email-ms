# Email Microservice

### Esta é a segunda parte do projeto e é possível encontrar a primeira parte aqui: [Microsserviço de Email](https://github.com/exxardo/user-api).

## Descrição
O **Email Microservice** é responsável por consumir mensagens publicadas no RabbitMQ e enviar e-mails utilizando SMTP. Ele também salva informações sobre os envios no banco de dados PostgreSQL.

---

## Arquitetura do Sistema

Abaixo está a arquitetura geral do sistema, que inclui o **User API**, o **Email Microservice**, e a comunicação via RabbitMQ utilizando a CloudAMQP:

![Arquitetura do Sistema](https://pplx-res.cloudinary.com/image/upload/v1737252173/user_uploads/QGQLRkWouVvyrVD/image.jpg)

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
spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
spring.datasource.username=<username>
spring.datasource.password=<password>
broker.queue.email.name=<nome-da-fila>
spring.rabbitmq.host=<host-rabbitmq>
spring.rabbitmq.username=<username>
spring.rabbitmq.password=<password>
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=<sua-senha>
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

## Fontes utilizadas para consulta

- [DevMedia](https://www.devmedia.com.br/conheca-o-spring-transactional-annotations/32472)
- [Google Senhas](https://support.google.com/accounts/answer/185833)
- [CloudAMQP](https://www.cloudamqp.com/blog/part4-rabbitmq-for-beginners-exchanges-routing-keys-bindings.html)
- [Spring Boot](https://docs.spring.io/spring-boot/index.html)

---

## Contato
Para dúvidas ou sugestões, entre em contato através do meu [LinkedIn](https://www.linkedin.com/in/eduardoramiro).