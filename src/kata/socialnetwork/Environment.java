package kata.socialnetwork;

public interface Environment {
	void addMessage(String user, Message message);

	void timeline(String user);

	void addFollowing(String bob, String alice);
}
