package com.egov.impl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by marcus on 24/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitacao {
    @NotNull
    private int id;
    @NotNull
    private int usuario;
    @NotNull
    private int tipo;
    @NotNull
    private String lat;
    @NotNull
    private String lng;
    @NotNull
    private String descricao;
    @NotNull
    private String endereco;
}
