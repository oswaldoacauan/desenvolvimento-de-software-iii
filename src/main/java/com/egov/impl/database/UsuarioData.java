package com.egov.impl.database;

import com.egov.impl.entity.Usuario;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
public interface UsuarioData {
    @Select("select * from usuario")
    List<Usuario> selectUsuarios();

    @Select("select * from usuario where id = #{id}")
    Usuario selectById(@Param("id") int id);

    @Insert("INSERT INTO usuario (id, nome, email, senha, cpf, rg, endereco, nascimento) " +
            "VALUES (NULL, #{nome}, #{email}, #{senha}, #{cpf}, #{rg}, #{endereco}, #{nascimento, typeHandler = com.egov.impl.handler.LocalDateTimeHandler})")
    int insertUsuario(Usuario usuario);

    @Update("UPDATE usuario " +
            "SET nome = #{nome}, " +
            "email = #{email}, " +
            "senha = #{senha}, " +
            "cpf = #{cpf}, " +
            "rg = #{rg}, " +
            "endereco = #{endereco}, " +
            "nascimento = #{nascimento, typeHandler = com.egov.impl.handler.LocalDateTimeHandler} " +
            "WHERE usuario.id = #{id};")
    int updateUsuario(Usuario usuario);

    @Delete("DELETE FROM USUARIO WHERE ID = #{id}")
    int deleteUsuario(@Param("id") int id);
}
