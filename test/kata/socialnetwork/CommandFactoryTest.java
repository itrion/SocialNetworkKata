package kata.socialnetwork;

import kata.socialnetwork.commands.FollowUser;
import kata.socialnetwork.commands.PostToWall;
import kata.socialnetwork.commands.ReadTimeLine;
import kata.socialnetwork.commands.ReadWall;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandFactoryTest {
	
	private CommandFactory factory = new CommandFactory();

	@Test
	public void identifies_post_command() {
		assertThat(factory.create("a_user -> a message"), is(instanceOf(PostToWall.class)));
	}
	
	@Test
	public void identifies_read_command() {
		assertThat(factory.create("just_a_user wall"), is(instanceOf(ReadWall.class)));
	}
	
	@Test
	public void identifies_follows_command() {
		assertThat(factory.create("a_user follows another_user"), is(instanceOf(FollowUser.class)));
	}

	@Test
	public void identifies_wall_command() {
		assertThat(factory.create("a_user"), is(instanceOf(ReadTimeLine.class)));
	}
}
