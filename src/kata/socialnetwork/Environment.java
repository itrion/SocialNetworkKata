package kata.socialnetwork;

import kata.socialnetwork.model.Message;
import kata.socialnetwork.model.User;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Environment {
	private Map<String, User> users = new HashMap<>();
	
	public void addMessage(String user, Message message) {
		users.putIfAbsent(user, new User(user));
		users.get(user).addMessage(message);
	}

	public List<Message> timeline(String user) {
		if (users.containsKey(user)) return users.get(user).timeline();
		return Collections.emptyList();
	}

	public void addFollowing(String follower, String followed) {
		if (!users.containsKey(follower) || !users.containsKey(followed)) return;
		users.get(follower).following(users.get(followed));
	}
	
	public List<String> followsOf(String user) {
		if (users.containsKey(user))
			return users.get(user).following()
					.stream()
					.map(User::name).collect(toList());
		return Collections.emptyList();
	}
	
	public Collection<User> users() {
		return users.values();
	}
}
