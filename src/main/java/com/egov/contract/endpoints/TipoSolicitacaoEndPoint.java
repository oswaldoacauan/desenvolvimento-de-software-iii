package com.egov.contract.endpoints;

import com.egov.contract.models.response.SolicitacaoResponse;
import com.egov.contract.service.TipoSolicitacaoService;
import com.egov.impl.entity.TipoSolicitacao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcus on 25/04/2017.
 */
@Path("/egov")
@Api(value = "Tipo Solicitacao",description = "Tipo Solicitacao EndPoints")
public class TipoSolicitacaoEndPoint {
    @Autowired
    TipoSolicitacaoService tipoSolicitacaoService;

    @GET
    @Path("/tiposolicitacao")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Consultar todos as tipos de solicitacao", response = TipoSolicitacao.class, responseContainer = "List")
    public List<TipoSolicitacao> getTipoSolicitacoes(){
        return tipoSolicitacaoService.getTipoSolicitacoes();
    }

    @GET
    @Path("/tiposolicitacao/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Consultar um tipo de solicitacao por ID", response = TipoSolicitacao.class, responseContainer = "List")
    public TipoSolicitacao getTipoSolicitacaoById(@PathParam("id") int id){
        return tipoSolicitacaoService.getTipoSolicitacao(id);
    }

    @POST
    @Path("/tiposolicitacao")
    @ApiOperation(value = "Insere um Tipo de Solicitacao", response = Integer.class)
    @Consumes({MediaType.APPLICATION_JSON})
    public int createTipoSolicitacao(@Valid TipoSolicitacao tipoSolicitacao){
        return tipoSolicitacaoService.insertTipoSolicitacao(tipoSolicitacao);
    }

    @PUT
    @Path("/tiposolicitacao")
    @ApiOperation(value = "Atualiza um Tipo de Solicitacao", response = Integer.class)
    @Consumes({MediaType.APPLICATION_JSON})
    public int updateTipoSolicitacao(@Valid TipoSolicitacao tipoSolicitacao){
        return tipoSolicitacaoService.updateTipoSolicitacao(tipoSolicitacao);
    }

    @DELETE
    @Path("/tiposolicitacao/{id}")
    @ApiOperation(value = "Deleta um Tipo de Solicitacao", response = Integer.class)
    public int deleteTipoSolicitacao(@PathParam("id") int id){
        return tipoSolicitacaoService.deleteTipoSolicitacao(id);
    }
}
