package kata.socialnetwork.commands;

import kata.socialnetwork.model.Environment;

public interface Command {
	String execute(Environment environment);
}
