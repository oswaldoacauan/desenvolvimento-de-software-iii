package com.egov.contract.endpoints;

import com.egov.contract.service.TipoSolicitacaoService;
import com.egov.impl.entity.TipoSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcus on 25/04/2017.
 */
@Path("/egov")
public class TipoSolicitacaoEndPoint {
    @Autowired
    TipoSolicitacaoService tipoSolicitacaoService;

    @GET
    @Path("/tiposolicitacao")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoSolicitacao> getTipoSolicitacoes(){
        return tipoSolicitacaoService.getTipoSolicitacoes();
    }

    @GET
    @Path("/tiposolicitacao/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TipoSolicitacao getTipoSolicitacaoById(@PathParam("id") int id){
        return tipoSolicitacaoService.getTipoSolicitacao(id);
    }

    @POST
    @Path("/tiposolicitacao")
    @Consumes({MediaType.APPLICATION_JSON})
    public int createTipoSolicitacao(@Valid TipoSolicitacao tipoSolicitacao){
        return tipoSolicitacaoService.insertTipoSolicitacao(tipoSolicitacao);
    }

    @PUT
    @Path("/tiposolicitacao")
    @Consumes({MediaType.APPLICATION_JSON})
    public int updateTipoSolicitacao(@Valid TipoSolicitacao tipoSolicitacao){
        return tipoSolicitacaoService.updateTipoSolicitacao(tipoSolicitacao);
    }

    @DELETE
    @Path("/tiposolicitacao/{id}")
    public int deleteTipoSolicitacao(@PathParam("id") int id){
        return tipoSolicitacaoService.deleteTipoSolicitacao(id);
    }
}
