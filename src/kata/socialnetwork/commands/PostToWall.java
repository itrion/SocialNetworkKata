package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;
import kata.socialnetwork.model.Message;

public class PostToWall implements Command {
	private final String user;
	private final Message message;
	
	public PostToWall(String user, Message message) {
		
		this.user = user;
		this.message = message;
	}
	
	@Override
	public String execute(Environment environment) {
		environment.addMessage(user, message);
		return "";
	}
}
