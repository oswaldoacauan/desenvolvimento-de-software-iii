package com.egov.impl.database;

import com.egov.impl.entity.Solicitacao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
public interface SolicitacaoData {
    @Select("Select * from solicitacao")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "usuario", column = "usuario_id"),
            @Result(property = "tipo", column = "tipo_id"),
            @Result(property = "lat", column = "lat"),
            @Result(property = "lng", column = "lng"),
            @Result(property = "descricao", column = "descricao"),
            @Result(property = "status", column = "status")})
    List<Solicitacao> selectSolicitacoes();

    @Select("select * from solicitacao where id = #{id}")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "usuario", column = "usuario_id"),
            @Result(property = "tipo", column = "tipo_id"),
            @Result(property = "lat", column = "lat"),
            @Result(property = "lng", column = "lng"),
            @Result(property = "descricao", column = "descricao"),
            @Result(property = "status", column = "status")})
    Solicitacao selectById(@Param("id") int id);

    @Insert("INSERT INTO solicitacao (id, usuario_id, tipo_id, lat, lng, descricao, endereco, status) " +
            "VALUES (NULL, " +
            "#{usuario}, " +
            "#{tipo}, " +
            "#{lat}, " +
            "#{lng}, " +
            "#{descricao}, " +
            "#{endereco}, " +
            "#{status}) ")
    int insertSolicitacao(Solicitacao solicitacao);

    @Update("UPDATE solicitacao " +
            "SET usuario_id = #{usuario.getId()}, " +
            "tipo_id = #{tipo.getId()}, " +
            "lat = #{lat}, " +
            "lng = #{lng}, " +
            "descricao = #{descricao}, " +
            "endereco = #{endereco}, " +
            "status = #{status} " +
            "WHERE solicitacao.id = #{id}")
    int updateSolicitacao(Solicitacao solicitacao);

    @Delete("delete from solicitacao where id = #{id}")
    int deleteSolicitacao(@Param("id") int id);
}
