package com.egov.impl.database;

import com.egov.impl.entity.TipoSolicitacao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by marcus on 24/04/2017.
 */
public interface TipoData {
    @Select("SELECT * FROM TIPO_SOLICITACAO")
    List<TipoSolicitacao> selectTipos();

    @Select("SELECT * FROM TIPO_SOLICITACAO WHERE ID = #{id}")
    TipoSolicitacao selectById(@Param("id") int id);

    @Insert("INSERT INTO tipo_solicitacao (id, descricao) VALUES (NULL, #{descricao})")
    int insertTipoSolicitacao(TipoSolicitacao tipoSolicitacao);

    @Update("UPDATE tipo_solicitacao SET descricao = #{descricao} WHERE tipo_solicitacao.id = #{id}")
    int updateTipoSolicitacao(TipoSolicitacao tipoSolicitacao);

    @Delete("DELETE FROM TIPO_SOLICITACAO WHERE ID = #{id}")
    int deleteTipoSolicitacao(@Param("id") int id);
}
