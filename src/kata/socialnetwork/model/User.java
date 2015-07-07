package kata.socialnetwork.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
	private final String name;
	private List<Message> messages;
	private List<User> follows;
	
	public User(String name) {
		this.name = name;
		this.follows = new ArrayList<>();
		this.messages = new ArrayList<>();
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public void following(User user) {
		follows.add(user);
	}
	
	public List<User> following() {
		return Collections.unmodifiableList(follows);
	}
	
	public String name() {
		return null;
	}

	public List<Message> timeline() {
		return messages;
	}
}
