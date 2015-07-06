package kata.socialnetwork.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
	private final String name;
	private List<User> follows;

	public User(String name) {
		this.name = name;
		this.follows = new ArrayList<>();
	}

	public void addMessage(Message message) {

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
}
