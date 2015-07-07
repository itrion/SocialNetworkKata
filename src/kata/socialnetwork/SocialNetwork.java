package kata.socialnetwork;

import static kata.socialnetwork.commands.CommandFactory.create;

public class SocialNetwork {
	private final Environment environment;
	
	public SocialNetwork(Environment environment) {
		this.environment = environment;
	}

	public String process(String input) {
		return create(input).execute(environment);
	}
}
