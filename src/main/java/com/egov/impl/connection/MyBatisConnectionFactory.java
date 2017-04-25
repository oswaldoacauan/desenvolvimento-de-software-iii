package com.egov.impl.connection;

/**
 * Created by marcus on 09/11/2016.
 */

import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.egov.impl.database")
public class MyBatisConnectionFactory {
    @Bean
    @ConfigurationProperties(prefix="datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlDataSource());
        sessionFactory.setTypeAliasesPackage("com.egov.impl.entity");
        try {
            return sessionFactory.getObject();
        } catch (Exception e) {
            throw new SqlSessionException("Não foi possivel inicializar a sessão", e);
        }
    }
}
