package kata.socialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static kata.socialnetwork.commands.CommandFactory.create;

public class SocialNetwork {
	private final Environment environment;
	
	public SocialNetwork(Environment environment){
		this.environment = environment;
	}

	public String process(String input) {
		return create(input).execute(environment);
	}
}
