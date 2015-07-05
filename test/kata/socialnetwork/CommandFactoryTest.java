package kata.socialnetwork;

import kata.socialnetwork.commands.PostToWall;
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
		assertThat(factory.create("just_a_user"), is(instanceOf(ReadWall.class)));
	}
}