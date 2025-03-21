# Backend - User Registration API

Este projeto implementa uma API REST para a criação. Ele segue os princípios de Clean Architecture e Domain-Driven Design (DDD) para garantir a organização, manutenibilidade e escalabilidade do código.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação.
* **Spring Boot:** Framework para desenvolvimento de aplicações Java.
* **PostgreSQL:** Banco de dados relacional.
* **JPA/Hibernate:** Framework para acesso a dados relacionais.
* **Lombok:** Biblioteca para reduzir o boilerplate do código Java.
* **Bean Validation:** API para validação de dados.
* **ViaCep API:** API para validação de CEP.

## Estrutura do Projeto

O projeto segue a Clean Architecture, organizado em camadas:

* **Domain:** Contém a lógica de negócio principal (entidades, repositórios, exceções).
* **Application:** Contém os casos de uso da aplicação (serviços).
* **Infrastructure:** Lida com detalhes de implementação (acesso ao banco de dados, clientes HTTP).
* **Presentation:** Responsável pela interação com o mundo externo (API REST - Controllers).

## Pré-requisitos

* Java 17 ou superior
* Maven
* PostgreSQL instalado e configurado

## Configuração

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/wenderenzo/UserRegisterBack.git
    ```

2.  **Configurar o banco de dados:**

    * Crie um banco de dados PostgreSQL.
    * Configure as propriedades de conexão no arquivo `src/main/resources/application.properties` ou `application.yml`:

        ```properties
        spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
        spring.datasource.username=<username>
        spring.datasource.password=<password>
        spring.datasource.driver-class-name=org.postgresql.Driver
        ```

      Substitua os placeholders com os valores corretos do seu ambiente.

3.  **Executar a aplicação:**

    * Use o Maven para executar a aplicação:

        ```bash
        mvn spring-boot:run
        ```

    * A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

* **POST /users:** Cria um novo usuário.
    * Corpo da requisição: JSON com os dados do usuário (name, email, password, zipCode).
* **GET /users:** Lista todos os usuários.

## Validação

* A validação dos dados é feita usando Bean Validation e a ViaCep API.

## Tratamento de Erros

* A API retorna códigos de status HTTP apropriados e mensagens de erro em formato JSON.