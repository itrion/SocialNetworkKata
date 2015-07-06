package kata.socialnetwork.commands;

import kata.socialnetwork.commands.*;
import kata.socialnetwork.model.Message;

public class CommandFactory {
	public Command create(String input) {
		if (input.contains("->")) return new PostToWall("", new Message(0, ""));
		if (input.contains("follows")) return new FollowUser("", "");
		if (input.contains("wall")) return new ReadWall("", null);
		else return new ReadTimeline("", null);
	}
}
