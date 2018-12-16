package br.com.webservice.configuracao.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/webservice")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("br.com.webservice.services");
    }
}
