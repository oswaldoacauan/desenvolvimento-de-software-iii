package com.egov.contract.models.response;

import com.egov.impl.entity.TipoSolicitacao;
import com.egov.impl.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by marcus on 24/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoResponse {
    private int id;
    private Usuario usuario;
    private TipoSolicitacao tipo;
    private String lat;
    private String lng;
    private String descricao;
    private String endereco;
}
