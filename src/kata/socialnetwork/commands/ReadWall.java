package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;
import kata.socialnetwork.MessageFormatter;
import kata.socialnetwork.Wall;
import kata.socialnetwork.sort.NewestFirst;

public class ReadWall implements Command {
	private final String user;
	private final MessageFormatter formatter;
	
	public ReadWall(String user, MessageFormatter formatter) {
		this.user = user;
		this.formatter = formatter;
	}
	
	public String execute(Environment environment) {
		Wall wall = new Wall(user, environment.timeline(user));
		for (String followed : environment.follows(user)) {
			wall.addToNewsFeed(followed, environment.timeline(followed));
		}
		return formatter.format(wall.sortBy(new NewestFirst()));
	}
}
