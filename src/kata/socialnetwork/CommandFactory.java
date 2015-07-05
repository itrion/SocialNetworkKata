package kata.socialnetwork;

import kata.socialnetwork.commands.Command;
import kata.socialnetwork.commands.Post;

public class CommandFactory {
	public Command create(String input) {
		return new Post();
	}
}
