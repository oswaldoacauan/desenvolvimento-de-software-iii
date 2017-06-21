package com.egov.contract.service;

import com.egov.contract.models.request.Login;
import com.egov.impl.database.UsuarioData;
import com.egov.impl.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioData usuarioData;

    public List<Usuario> getUsuarios(){
        return usuarioData.selectUsuarios();
    }

    public Usuario getUsuario(int id){
        return usuarioData.selectById(id);
    }

    public long insertUsuario(Usuario usuario){
        usuarioData.insertUsuario(usuario);
        return usuarioData.lastInsertId();
    }

    public int updateUsuario(Usuario usuario){
        return usuarioData.updateUsuario(usuario);
    }

    public int deleteUsuario(int id){
        return usuarioData.deleteUsuario(id);
    }

    public boolean login(Login login){
        return usuarioData.login(login.getEmail(),login.getSenha()) > 0;
    }
}
