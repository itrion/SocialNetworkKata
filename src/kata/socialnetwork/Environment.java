package kata.socialnetwork;

import kata.socialnetwork.model.Message;

import java.util.*;

public class Environment {
	private List<String> users = new ArrayList<>();
	private Map<String, List<Message>> messages = new HashMap<>();

	public void addMessage(String user, Message message) {
		if (users.contains(user))
			messages.get(user).add(message);
		else
			firstMessage(user, message);
	}
	
	private void firstMessage(String user, Message message) {
		users.add(user);
		messages.put(user, Arrays.asList(message));
	}
	
	
	public List<Message> timeline(String user) {
		throw new UnsupportedOperationException();
	}
	
	public void addFollowing(String follower, String followed) {
	}
	
	public List<String> follows(String bob) {
		throw new UnsupportedOperationException();
	}
	
	public List<String> users() {
		return Collections.unmodifiableList(users);
	}
}
