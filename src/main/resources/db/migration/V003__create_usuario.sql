CREATE TABLE usuario
(
    id    BIGINT PRIMARY KEY IDENTITY (1,1),
    email NVARCHAR(150) UNIQUE NOT NULL,
    senha NVARCHAR(255)        NOT NULL
);


INSERT INTO usuario (email, senha)
VALUES ('admin@email.com', '$2a$10$/umjFz31/tdiVJdqJOGy7uV5d1UMP1/HGVlfRa71PmzAKUMjDvMgu');
