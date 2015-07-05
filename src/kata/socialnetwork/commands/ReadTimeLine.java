package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;
import kata.socialnetwork.Message;
import kata.socialnetwork.MessageFormatter;

public class ReadTimeline implements Command {
	private final String user;
	private final MessageFormatter formatter;

	public ReadTimeline(String user, MessageFormatter formatter) {
		this.user = user;
		this.formatter = formatter;
	}

	public String execute(Environment environment) {
		StringBuilder resultBuilder = new StringBuilder();
		for (Message message : environment.timeline(user)) {
			resultBuilder.append(formatter.toString(message));
		}
		return resultBuilder.toString();
	}
}
