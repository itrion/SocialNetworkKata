package kata.socialnetwork;

import kata.socialnetwork.commands.FollowUser;
import kata.socialnetwork.commands.PostToWall;
import kata.socialnetwork.commands.ReadTimeline;
import kata.socialnetwork.commands.ReadWall;
import kata.socialnetwork.model.Environment;
import kata.socialnetwork.model.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

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
		when(formatter.format(anyList())).thenReturn("");
		assertThat(new ReadTimeline(user, formatter).execute(environment), is(""));
		verify(environment).timeline(user);
		verify(formatter).format(anyList());
	}

	@Test
	public void follow_user_adds_right_side_user_to_the_left_one_following_list() {
		String follower = "Alice";
		String followed = "Bob";
		new FollowUser(follower, followed).execute(environment);
		verify(environment).addFollowing(follower, followed);
	}
	
	@Test
	public void read_wall_query_the_followed_timelines_and_store_the_result() {
		String user = "Alice";
		MessageFormatter formatter = mock(MessageFormatter.class);
		when(environment.follows(user)).thenReturn(Arrays.asList("Bob", "Patrice"));
		when(formatter.format(anyList())).thenReturn("");
		assertThat(new ReadWall(user, formatter).execute(environment), is(""));
		
		verify(environment).follows(user);
		verify(environment).timeline("Alice");
		verify(environment).timeline("Bob");
		verify(environment).timeline("Patrice");
		verify(formatter).format(anyList());
	}
}
