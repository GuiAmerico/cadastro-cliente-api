CREATE TABLE cliente
(
    id       BIGINT PRIMARY KEY IDENTITY(1,1),
    nome     NVARCHAR(150) NOT NULL,
    email    NVARCHAR(150) UNIQUE NOT NULL,
    logotipo VARBINARY( MAX) NOT NULL
);

CREATE TABLE endereco
(
    id         BIGINT PRIMARY KEY IDENTITY(1,1),
    logradouro NVARCHAR(250) NOT NULL,
    cliente_id  BIGINT NOT NULL,

    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);