package kata.socialnetwork;

import kata.socialnetwork.commands.Post;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandFactoryTest {
	
	@Test
	public void identifies_post_command() {
		assertThat(new CommandFactory().create("a_user -> a message"), is(instanceOf(Post.class)));
	}
}
