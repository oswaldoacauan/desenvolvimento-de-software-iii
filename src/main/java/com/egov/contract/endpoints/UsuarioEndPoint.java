package com.egov.contract.endpoints;

import com.egov.contract.models.response.SolicitacaoResponse;
import com.egov.contract.service.UsuarioService;
import com.egov.impl.entity.Usuario;
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
@Api(value = "Usuario",description = "Usuario EndPoints")
public class UsuarioEndPoint {
    @Autowired
    UsuarioService usuarioService;

    @GET
    @Path("/usuario")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Consultar todos as Usuarios", response = Usuario.class, responseContainer = "List")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GET
    @Path("/usuario/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Consultar uma Solicitacao pro ID", response = Usuario.class)
    public Usuario getUsuario(@PathParam("id") int id) {
        return usuarioService.getUsuario(id);
    }

    @POST
    @Path("/usuario")
    @Consumes({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Insere um Usuario", response = Integer.class)
    public int createUsuario(@Valid Usuario usuario) {
        return usuarioService.insertUsuario(usuario);
    }

    @PUT
    @Path("/usuario")
    @Consumes({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Atualiza um Usuario", response = Integer.class)
    public int updateUsuario(@Valid Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DELETE
    @Path("/usuario/{id}")
    @ApiOperation(value = "Deleta um Usuario", response = Integer.class)
    public int deleteUsuario(@PathParam("id") int id){
        return usuarioService.deleteUsuario(id);
    }
}