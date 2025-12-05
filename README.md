# 📚 API de Biblioteca

Este projeto é uma API RESTful desenvolvida em **Java com Spring Boot**, que permite gerenciar livros, autores e categorias em uma biblioteca.

## 🚀 Funcionalidades

- 📖 CRUD de Livros
- ✍️ CRUD de Autores
- 🏷️ CRUD de Categorias
- 🔍 Busca por título e ISBN
- 📄 Consulta personalizada de resumo do livro com título, autor e categoria

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL 8
- Hibernate
- Maven
- DBeaver (client de banco de dados)
- Postman (para testes de API)

---

## 📦 Estrutura do Projeto
src
├── controller # Endpoints da API
├── service # Regras de negócio
├── repository # Interfaces com banco de dados
├── model # Entidades JPA
├── dto # Objetos de transferência de dados
└── DemoApplication # Classe principal


---

## 🔧 Configuração

### 1. Banco de Dados

Certifique-se de que o MySQL está rodando e configure o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=root
spring.datasource.password=SUASENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

```
`Dependencias maven`
```
<dependencies>
  <!-- Spring Boot -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <!-- MySQL -->
  <dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.1.0</version>
  </dependency>
</dependencies>
