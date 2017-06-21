package com.egov.contract.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by flok2 on 20/06/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @NotNull
    String email;
    @NotNull
    String senha;
}
