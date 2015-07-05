package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;
import kata.socialnetwork.Message;
import kata.socialnetwork.MessageComparator;
import kata.socialnetwork.MessageFormatter;

import java.util.List;

public class ReadWall implements Command {
	private final String user;
	private final MessageFormatter formatter;
	
	public ReadWall(String user, MessageFormatter formatter) {
		
		this.user = user;
		this.formatter = formatter;
	}
	
	public String execute(Environment environment) {
		List<Message> wall = environment.timeline(user);
		for (String followed : environment.follows(user)) {
			wall.addAll(environment.timeline(followed));
		}
		wall.sort(new MessageComparator());
		return formatter.format(wall);
	}
}
