package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;
import kata.socialnetwork.MessageFormatter;

public class ReadTimeline implements Command {
	private final String user;
	private final MessageFormatter formatter;

	public ReadTimeline(String user, MessageFormatter formatter) {
		this.user = user;
		this.formatter = formatter;
	}

	@Override
	public String execute(Environment environment) {
		return formatter.format(environment.timeline(user));
	}
}
