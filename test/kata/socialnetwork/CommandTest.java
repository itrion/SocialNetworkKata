package kata.socialnetwork;

import kata.socialnetwork.commands.PostToWall;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandTest {
	@Test
	public void post_to_wall_add_the_message_to_the_user() {
		Environment environment = mock(Environment.class);
		Message message = mock(Message.class);
		String user = "Alice";
		new PostToWall(user, message).execute(environment);
		verify(environment).addMessage(user, message);
	}
}
