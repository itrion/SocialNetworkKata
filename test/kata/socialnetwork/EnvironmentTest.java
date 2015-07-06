package kata.socialnetwork;

import kata.socialnetwork.model.Message;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EnvironmentTest {
	@Test
	public void create_new_users_when_posting_for_first_time() {
		Environment environment = new Environment();
		environment.addMessage("Alice", new Message(0, ""));
		environment.addMessage("Bob", new Message(0, ""));
		environment.addMessage("Patrice", new Message(0, ""));
		assertThat(environment.users().size(), is(3));
	}
}
