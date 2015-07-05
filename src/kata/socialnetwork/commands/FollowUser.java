package kata.socialnetwork.commands;

import kata.socialnetwork.Environment;

public class FollowUser implements Command{
	private final String follower;
	private final String followed;

	public FollowUser(String follower, String followed) {
		this.follower = follower;
		this.followed = followed;
	}

	public void execute(Environment environment) {
		environment.addFollowing(follower, followed);
	}
}
