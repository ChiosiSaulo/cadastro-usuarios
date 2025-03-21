# Cadastro de Usuários

Este é um projeto de cadastro de usuários desenvolvido em **Java** utilizando **Spring Boot**. O objetivo é demonstrar habilidades no desenvolvimento de APIs REST, persistência de dados e boas práticas de desenvolvimento.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Spring Web**
- **Banco de dados H2 (em memória)**
- **Maven**

## Requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven**

## Configuração do Banco de Dados

O projeto está configurado para utilizar o **H2 Database**, um banco de dados em memória para fins de desenvolvimento e testes.

Caso queira usar outro banco de dados, altere as configurações no arquivo `application.properties` dentro de `src/main/resources`.

## Como Executar o Projeto

1. **Clone o repositório**
   ```sh
   git clone https://github.com/seu-usuario/cadastro-usuarios.git
   cd cadastro-usuarios
   ```
2. **Compile e execute o projeto**
   ```sh
   mvn spring-boot:run
   ```

O servidor iniciará na porta **8080**. A API estará acessível em `http://localhost:8080/`

## Endpoints da API

| Método | Endpoint          | Descrição                  |
|---------|------------------|------------------------------|
| GET     | `/users`         | Lista todos os usuários     |
| GET     | `/users/{id}`    | Obtém um usuário por ID    |
| POST    | `/users`         | Cadastra um novo usuário    |
| PUT     | `/users/{id}`    | Atualiza um usuário por ID  |
| DELETE  | `/users/{id}`    | Remove um usuário por ID    |

## Testes

Para rodar os testes automatizados, utilize o seguinte comando:
```sh
mvn test
```

## Contribuição

Se deseja contribuir com melhorias para o projeto, siga os passos:

1. Fork o repositório
2. Crie um branch (`git checkout -b feature/nova-feature`)
3. Faça as alterações e commit (`git commit -m 'Adiciona nova funcionalidade'`)
4. Envie para o repositório (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença **MIT**. Veja o arquivo `LICENSE` para mais detalhes.

