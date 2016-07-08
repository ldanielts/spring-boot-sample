package br.com.cinq.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	private Greeting greeting;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting() {
		return new Greeting();
	}

	@RequestMapping(value = "/greeting/change", method = RequestMethod.POST)
	@ResponseBody
	public Greeting changeGreeting(@RequestBody String content) {
		Greeting greeting = new Greeting();
		greeting.setContent(content);
		return greeting;
	}
	
	@RequestMapping(value = "/jersey/greeting", method = RequestMethod.GET)
	public Greeting getJerseyGreeting() {
		return greeting;
	}

	@RequestMapping(value = "/jersey/greeting/change", method = RequestMethod.POST)
	@ResponseBody
	public Greeting setJerseyGreeting(@RequestBody String content) {
		greeting.setContent(content);
		return greeting;
	}

}
