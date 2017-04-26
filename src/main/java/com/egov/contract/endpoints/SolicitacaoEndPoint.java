package com.egov.contract.endpoints;

import com.egov.contract.service.SolicitacaoService;
import com.egov.contract.models.response.SolicitacaoResponse;
import com.egov.impl.entity.Solicitacao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
@Path("/egov")
@Api(value = "Solicitacao",description = "Solicitacao EndPoints")
public class SolicitacaoEndPoint {
    @Autowired
    SolicitacaoService solicitacaoService;

    @GET
    @Path("/solicitacao")
    @ApiOperation(value = "Consultar todas as Solicitacoes", response = SolicitacaoResponse.class, responseContainer = "List")
    @Produces({MediaType.APPLICATION_JSON})
    public List<SolicitacaoResponse> getSolicitacoes(){
        return solicitacaoService.getSolicitacoes();
    }

    @GET
    @Path("/solicitacao/{id}")
    @ApiOperation(value = "Consultar Solicitacao por ID", response = SolicitacaoResponse.class)
    @Produces({MediaType.APPLICATION_JSON})
    public SolicitacaoResponse getSolicitacaoById(@PathParam("id") int id){
        return solicitacaoService.getSolicitacao(id);
    }

    @POST
    @Path("/solicitacao")
    @ApiOperation(value = "Insere uma Solicitacao", response = Integer.class)
    @Consumes({MediaType.APPLICATION_JSON})
    public int createSolicitacao(@Valid Solicitacao solicitacao){
        return solicitacaoService.insertSolicitacao(solicitacao);
    }

    @PUT
    @Path("/solicitacao")
    @ApiOperation(value = "Atualiza uma Solicitacao", response = Integer.class)
    @Consumes({MediaType.APPLICATION_JSON})
    public int updateSolicitacao(@Valid Solicitacao solicitacao){
        return solicitacaoService.updateSolicitacao(solicitacao);
    }

    @DELETE
    @Path("/solicitacao/{id}")
    @ApiOperation(value = "Deleta uma Solicitacao", response = Integer.class)
    public int deleteSolicitacao(@PathParam("id") int id){
        return solicitacaoService.deleteSolicitacao(id);
    }
}
