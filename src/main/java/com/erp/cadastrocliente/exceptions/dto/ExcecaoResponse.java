package com.erp.cadastrocliente.exceptions.dto;

import com.erp.cadastrocliente.exceptions.AbstractException;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcecaoResponse {

    private String descricao;
    private String codigoErro;

    public ExcecaoResponse(AbstractException ex) {
        this.descricao = ex.getMessage();
        this.codigoErro = ex.getCodigo();
    }

    public ExcecaoResponse(TipoExcecao tipoExcecao) {
        this.descricao = tipoExcecao.getDescricao();
        this.codigoErro = tipoExcecao.getCodigo();
    }
}
