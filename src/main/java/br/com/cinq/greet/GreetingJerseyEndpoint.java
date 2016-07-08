package br.com.cinq.greet.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cinq.greet.Greeting;

@Component
@Path("greetingEndpoint")
public class GreetingJerseyEndpoint {

	@Autowired
	private Greeting greeting;

	@GET
	@Produces("application/json")
	public Greeting getGreeting() {
		return greeting;
	}

	@POST
	@Consumes("application/json")
	public Greeting change(String newMessage) {
		greeting.setContent(newMessage);
		return greeting;
	}
}
