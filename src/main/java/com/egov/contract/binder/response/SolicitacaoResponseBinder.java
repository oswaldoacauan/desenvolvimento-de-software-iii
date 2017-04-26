package com.egov.contract.binder.response;

import com.egov.contract.models.response.SolicitacaoResponse;
import com.egov.impl.entity.Solicitacao;

/**
 * Created by marcus on 24/04/2017.
 */
public class SolicitacaoResponseBinder {
    public static SolicitacaoResponse bindToSolicitacaoResponse(Solicitacao solicitacao){
        SolicitacaoResponse solicitacaoResponse = new SolicitacaoResponse();

        solicitacaoResponse.setId(solicitacao.getId());
        solicitacaoResponse.setDescricao(solicitacao.getDescricao());
        solicitacaoResponse.setEndereco(solicitacao.getEndereco());
        solicitacaoResponse.setLat(solicitacao.getLat());
        solicitacaoResponse.setLng(solicitacao.getLng());

        return solicitacaoResponse;
    }
}
