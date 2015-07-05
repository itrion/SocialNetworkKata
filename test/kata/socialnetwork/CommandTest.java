package kata.socialnetwork;

import kata.socialnetwork.commands.FollowUser;
import kata.socialnetwork.commands.PostToWall;
import kata.socialnetwork.commands.ReadTimeline;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandTest {
	
	private Environment environment;
	
	@Before
	public void setUp() throws Exception {
		environment = mock(Environment.class);
	}
	
	@Test
	public void post_to_wall_add_the_message_to_the_user() {
		Message message = mock(Message.class);
		String user = "Alice";
		new PostToWall(user, message).execute(environment);
		verify(environment).addMessage(user, message);
	}
	
	@Test
	public void read_timeline_query_the_environment_and_returns_the_result() {
		MessageFormatter formatter = mock(MessageFormatter.class);
		String user = "Bob";
		new ReadTimeline(user, formatter).execute(environment);
		verify(environment).timeline(user);
	}

	@Test
	public void follow_user_adds_right_side_user_to_the_left_one_following_list() {
		String follower = "Alice";
		String followed = "Bob";
		new FollowUser(follower, followed).execute(environment);
		verify(environment).addFollowing(follower, followed);
	}
}
