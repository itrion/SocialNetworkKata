package kata.socialnetwork;

import kata.socialnetwork.commands.Command;
import kata.socialnetwork.commands.PostToWall;
import kata.socialnetwork.commands.ReadWall;

public class CommandFactory {
	public Command create(String input) {
		if (input.contains("->"))
			return new PostToWall();
		else return new ReadWall();
	}
}
