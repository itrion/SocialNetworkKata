package kata.socialnetwork.model;

import java.util.List;

public interface Environment {
	void addMessage(String user, Message message);

	List<Message> timeline(String user);

	void addFollowing(String follower, String followed);

	List<String> follows(String bob);
}
