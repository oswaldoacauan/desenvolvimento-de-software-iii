package com.egov.impl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by marcus on 24/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @NotNull
    private int id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    private String cpf;
    @NotNull
    private String rg;
    @NotNull
    private String endereco;
    @NotNull
    private LocalDateTime nascimento;
}
