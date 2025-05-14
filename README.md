[//]: # (```markdown)
# Cadastro de Clientes - ERP

Este projeto é uma aplicação de cadastro de clientes desenvolvida em **Java** utilizando o framework **Spring Boot**. A aplicação permite criar, atualizar, deletar e consultar clientes.

## Tecnologias Utilizadas

- **Java 8**
- **Spring Boot**
- **Spring Security**
- **Maven**
- **ModelMapper**
- **Lombok**
- **SQL Server** 
- **JWT**

## Funcionalidades

- **Criar Cliente**: Cadastro de novos clientes com validação de e-mail.
- **Atualizar Cliente**: Atualização de informações de clientes existentes.
- **Deletar Cliente**: Exclusão de clientes pelo ID.
- **Consultar Cliente por ID**: Busca de informações detalhadas de um cliente.
- **Listar Todos os Clientes**: Retorna uma lista de todos os clientes cadastrados.
- **Autenticação e Autorização** Login com JWT.
## Estrutura do Projeto

- `controller`: Contém os endpoints REST para manipulação de clientes.
- `service`: Implementa a lógica de negócios da aplicação.
- `repository`: Gerencia a persistência de dados.
- `model`: Define as entidades do domínio.
- `exceptions`: Contém as exceções personalizadas para tratamento de erros.

## Endpoints

### Base URL: `/api/v1/clientes`

- **POST** `/`  
  Cria um novo cliente.  
  **Consumo**: `multipart/form-data`

- **PUT** `/{id}`  
  Atualiza um cliente existente.  
  **Consumo**: `multipart/form-data`

- **DELETE** `/{id}`  
  Deleta um cliente pelo ID.

- **GET** `/{id}`  
  Retorna os detalhes de um cliente pelo ID.

- **GET** `/`  
  Retorna uma lista de todos os clientes cadastrados.
### Base URL: `/api/publico/v1/autenticacao`

- **POST** `/login`  
  Realiza o login do usuário e retorna um token JWT.

### Rotas Públicas e Privadas:
- Qual rota mapeada será requerido autenticação, a menos que, 
  explicitamente definido como público utilizando o prefixo `/publico`.

## Exceções Personalizadas
- **RecursoNaoEncontradoException**: Lançada quando um cliente não é encontrado, por exemplo.
- **RecursoJaExisteException**: Lançada quando um e-mail já está cadastrado, por exemplo.

## Como Executar

1. Certifique-se de ter o **Java 8**, **Maven** e o **SQL Server**/**Docker** instalados.
2. Clone o repositório:
   ```bash
   git clone https://github.com/GuiAmerico/cadastro-cliente-api.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd cadastro-cliente
   ```
4. Configure o arquivo `application.properties` e `application-default.properties`
   - 4.1. Altere a URL de conexão do banco de dados para o seu ambiente local.
   - 4.2. Certifique-se de criar o banco `cadastro_cliente` ou altere para algum já existente
   - 4.3. Configure as credenciais do banco de dados.
   - 4.4. Adicione sua secret do JWT, caso não pode criar utilizando esse [site](https://www.rapidtables.com/convert/number/ascii-to-hex.html) **(Certifique-se de utlizar `UTF-16` para encoding e `None` para o delimiter)**
   - <img src="https://cdn.discordapp.com/attachments/1028712344110514176/1372153262542684180/image.png?ex=6825bccf&is=68246b4f&hm=2fb396f7d7c456f1e9b98e7915c824497b8c854d6f002a78c5e630850efa218d&" alt="Imagem com problema"/>
5. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
6. Acesse a aplicação em `http://localhost:8081`.

7. Caso queria utilizar docker para rodar a aplicação
- 7.1: Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:
<br>
`MSSQL_SA_PASSWORD=SuaSenhaForteAqui!`
<br>
`JWT_SECRET=<SuaSecretAqui>!` *gerar no passo 4.3*
- 7.2: Execute o docker com o seguinte comando:

```bash
   docker compose up
```

### Login
```
{
    "email": "admin@email.com",
    "senha": "Admin@123"
}
```
