package kata.socialnetwork.view;

import kata.socialnetwork.MessageFormatter;
import kata.socialnetwork.model.Message;

public class MessageView {
	private final String owner;
	private final Message message;

	public MessageView(String owner, Message message) {
		this.owner = owner;
		this.message = message;
	}

	public Message message() {
		return message;
	}

	public String format(MessageFormatter formatter) {
		return owner + " - " + formatter.format(message);
	}
}
