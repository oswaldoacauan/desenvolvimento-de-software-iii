package com.egov.contract.endpoints;

import com.egov.contract.service.UsuarioService;
import com.egov.impl.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
@Path("/egov")
public class UsuarioEndPoint {
    @Autowired
    UsuarioService usuarioService;

    @GET
    @Path("/usuario")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GET
    @Path("/usuario/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario getUsuario(@PathParam("id") int id) {
        return usuarioService.getUsuario(id);
    }

    @POST
    @Path("/usuario")
    @Consumes({MediaType.APPLICATION_JSON})
    public int createUsuario(@Valid Usuario usuario) {
        return usuarioService.insertUsuario(usuario);
    }

    @PUT
    @Path("/usuario")
    @Consumes({MediaType.APPLICATION_JSON})
    public int updateUsuario(@Valid Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DELETE
    @Path("/usuario/{id}")
    public int deleteUsuario(@PathParam("id") int id){
        return usuarioService.deleteUsuario(id);
    }
}