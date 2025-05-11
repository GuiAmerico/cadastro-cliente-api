package com.erp.cadastrocliente.exceptions.dto;

import com.erp.cadastrocliente.exceptions.AbstractException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExcecaoResponse {

    private String description;
    @JsonProperty("error_code")
    private String errorCode;

    public ExcecaoResponse(AbstractException ex) {
        this.description = ex.getMessage();
        this.errorCode = ex.getCodigo();
    }
}
