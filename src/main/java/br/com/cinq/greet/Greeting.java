package br.com.cinq.greet;

import java.util.Calendar;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Greeting {

	private String content;

	public Greeting() {
		this.content = "Message " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String newContent) {
		this.content = newContent;
	}

}
