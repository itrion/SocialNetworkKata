package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;

public interface Command {
	String execute(Environment environment);
}
