package com.egov.contract.config;

import com.egov.contract.endpoints.SolicitacaoEndPoint;
import com.egov.contract.endpoints.TipoSolicitacaoEndPoint;
import com.egov.contract.endpoints.UsuarioEndPoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        super();
        register(SolicitacaoEndPoint.class);
        register(TipoSolicitacaoEndPoint.class);
        register(UsuarioEndPoint.class);
        register(JacksonFeature.class);
        register(CORSFilter.class);
    }
}