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
public class TipoSolicitacao {
    @NotNull
    private int id;
    @NotNull
    private String descricao;
}
