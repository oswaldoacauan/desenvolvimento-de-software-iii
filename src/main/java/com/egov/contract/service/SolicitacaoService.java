package com.egov.contract.service;

import com.egov.contract.binder.response.SolicitacaoResponseBinder;
import com.egov.contract.models.response.SolicitacaoResponse;
import com.egov.impl.database.SolicitacaoData;
import com.egov.impl.entity.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
@Service
@Transactional
public class SolicitacaoService {
    @Autowired
    SolicitacaoData solicitacaoData;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TipoSolicitacaoService tipoSolicitacaoService;

    public List<SolicitacaoResponse> getSolicitacoes(){
        List<SolicitacaoResponse> list = new ArrayList<>();

        solicitacaoData.selectSolicitacoes().forEach(solicitacao -> {
            list.add(buildResponse(solicitacao));
        });

        return list;
    }

    public SolicitacaoResponse getSolicitacao(int id){
        return buildResponse(solicitacaoData.selectById(id));
    }

    public int insertSolicitacao(Solicitacao solicitacao){
        return solicitacaoData.insertSolicitacao(solicitacao);
    }

    public int updateSolicitacao(Solicitacao solicitacao){
        return solicitacaoData.updateSolicitacao(solicitacao);
    }

    public int deleteSolicitacao(int id){
        return solicitacaoData.deleteSolicitacao(id);
    }

    private SolicitacaoResponse buildResponse(Solicitacao solicitacao){
        SolicitacaoResponse solicitacaoResponse = SolicitacaoResponseBinder.bindToSolicitacaoResponse(solicitacao);
        solicitacaoResponse.setUsuario(usuarioService.getUsuario(solicitacao.getUsuario()));
        solicitacaoResponse.setTipo(tipoSolicitacaoService.getTipoSolicitacao(solicitacao.getTipo()));
        return solicitacaoResponse;
    }
}
