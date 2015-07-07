package kata.socialnetwork.commands;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandFactoryTest {
	

	@Test
	public void identifies_post_to_wall_command() {
		assertThat(CommandFactory.createFrom("a_user -> a message"), is(instanceOf(PostToWall.class)));
	}
	
	@Test
	public void identifies_read_wall_command() {
		assertThat(CommandFactory.createFrom("just_a_user wall"), is(instanceOf(ReadWall.class)));
	}
	
	@Test
	public void identifies_follow_user_command() {
		assertThat(CommandFactory.createFrom("a_user follows another_user"), is(instanceOf(FollowUser.class)));
	}

	@Test
	public void identifies_read_time_line_command() {
		assertThat(CommandFactory.createFrom("a_user"), is(instanceOf(ReadTimeline.class)));
	}
}
