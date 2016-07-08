package br.com.cinq.greet.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GreetingJerseyEndpoint.class);
    }

}