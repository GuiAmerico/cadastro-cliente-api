----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_criar_cliente_com_enderecos
    @nome NVARCHAR(150),
    @email NVARCHAR(150),
    @logotipo VARBINARY(MAX),
    @enderecos_json NVARCHAR(MAX)
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        BEGIN TRAN;

        INSERT INTO cliente (nome, email, logotipo)
        VALUES (@nome, @email, @logotipo);

        DECLARE @cliente_id BIGINT = SCOPE_IDENTITY();

        INSERT INTO endereco (logradouro, cliente_id)
        SELECT JSON_VALUE(value, '$.logradouro'), @cliente_id
        FROM OPENJSON(@enderecos_json);

        COMMIT;

        -- retorna o cliente recém-criado
        SELECT id, nome, email, logotipo
        FROM cliente
        WHERE id = @cliente_id;

    END TRY
    BEGIN CATCH
        ROLLBACK;
        THROW;
    END CATCH
END;
GO

----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_deletar_cliente
@cliente_id BIGINT
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        BEGIN TRAN;

        DELETE FROM endereco WHERE cliente_id = @cliente_id;
        DELETE FROM cliente WHERE id = @cliente_id;

        COMMIT;
    END TRY
    BEGIN CATCH
        ROLLBACK;
        THROW;
    END CATCH
END;
GO

----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_atualizar_cliente
    @cliente_id BIGINT,
    @nome NVARCHAR(150),
    @email NVARCHAR(150),
    @logotipo VARBINARY(MAX)
AS
BEGIN
    UPDATE cliente
    SET nome     = @nome,
        email    = @email,
        logotipo = @logotipo
    WHERE id = @cliente_id;
END;
GO

----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_atualizar_endereco
    @endereco_id BIGINT,
    @logradouro NVARCHAR(250)
AS
BEGIN
    UPDATE endereco
    SET logradouro = @logradouro
    WHERE id = @endereco_id;
END;
GO

----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_deletar_endereco
@endereco_id BIGINT
AS
BEGIN
    DELETE FROM endereco
    WHERE id = @endereco_id;
END;
GO

----------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_adicionar_endereco
    @cliente_id BIGINT,
    @logradouro NVARCHAR(250)
AS
BEGIN
    INSERT INTO endereco (logradouro, cliente_id)
    VALUES (@logradouro, @cliente_id);
END;
GO
