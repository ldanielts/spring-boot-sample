package br.com.cinq.greet.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.Collections;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.cinq.greet.Application;
import br.com.cinq.greet.Greeting;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class EndpointTest {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testGetMessage() {
		String result = restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class);
		JSONObject jsonObject = new JSONObject(result);
		String actual = (String) jsonObject.get("content");
		String expected = "Message " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void testPostNewMessage() {
		String result = restTemplate.postForObject("http://localhost:" + port + "/greeting/change", "new message",
				String.class);
		JSONObject jsonObject = new JSONObject(result);
		String actual = (String) jsonObject.get("content");
		String expected = "new message";
		assertThat(actual, is(equalTo(expected)));
	}
	

	@Test
	public void testGetMessageUsingJersey() {
		String result = restTemplate.getForObject("http://localhost:" + port + "/jersey/greetingEndpoint", String.class);
		JSONObject jsonObject = new JSONObject(result);
		String actual = (String) jsonObject.get("content");
		String expected = "Message " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		assertThat(actual, is(equalTo(expected)));
	}

	@Test @Ignore
	public void testPostNewMessageUsingJersey() {
		Greeting newGreeting = new Greeting();
		newGreeting.setContent("new message");
		Greeting result = restTemplate.postForObject("http://localhost:" + port + "/jersey/greetingEndpoint", newGreeting, Greeting.class, Collections.<String, Object>emptyMap());
		JSONObject jsonObject = new JSONObject(result);
		String actual = (String) jsonObject.get("content");
		String expected = "new message";
		assertThat(actual, is(equalTo(expected)));
	}
	
}
