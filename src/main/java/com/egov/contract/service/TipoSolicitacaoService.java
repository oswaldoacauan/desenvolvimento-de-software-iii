package com.egov.contract.service;

import com.egov.impl.database.TipoData;
import com.egov.impl.entity.TipoSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
@Service
@Transactional
public class TipoSolicitacaoService {
    @Autowired
    TipoData tipoData;

    public List<TipoSolicitacao> getTipoSolicitacoes(){
        return tipoData.selectTipos();
    }

    public TipoSolicitacao getTipoSolicitacao(int id){
        return tipoData.selectById(id);
    }

    public int insertTipoSolicitacao(TipoSolicitacao tipoSolicitacao){
        return tipoData.insertTipoSolicitacao(tipoSolicitacao);
    }

    public int updateTipoSolicitacao(TipoSolicitacao tipoSolicitacao){
        return tipoData.updateTipoSolicitacao(tipoSolicitacao);
    }

    public int deleteTipoSolicitacao(int id){
        return tipoData.deleteTipoSolicitacao(id);
    }
}
