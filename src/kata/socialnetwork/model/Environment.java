package kata.socialnetwork.model;

import java.util.List;

public class Environment {
	public void addMessage(String user, Message message) {
	}

	public List<Message> timeline(String user) {
		throw new UnsupportedOperationException();
	}

	public void addFollowing(String follower, String followed) {
	}

	public List<String> follows(String bob) {
		throw new UnsupportedOperationException();
	}
}
