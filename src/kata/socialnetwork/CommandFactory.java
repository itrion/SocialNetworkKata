package kata.socialnetwork;

import kata.socialnetwork.commands.*;

public class CommandFactory {
	public Command create(String input) {
		if (input.contains("->")) return new PostToWall();
		if (input.contains("follows")) return new FollowUser();
		if (input.contains("wall")) return new ReadWall();
		else return new ReadTimeLine();
	}
}
