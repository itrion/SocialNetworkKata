package kata.socialnetwork;

import kata.socialnetwork.model.Message;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EnvironmentTest {
	
	private Environment environment;
	
	@Before
	public void setUp() throws Exception {
		environment = new Environment();
	}
	
	@Test
	public void create_new_users_when_posting_for_first_time() {
		environment.addMessage("Alice", new Message(0, ""));
		environment.addMessage("Bob", new Message(0, ""));
		environment.addMessage("Patrice", new Message(0, ""));
		assertThat(environment.users().size(), is(3));
	}
	
	@Test
	public void only_existing_user_can_follow() {
		String existingUser = "existingUser";
		String nonExistingUser = "nonExisting";
		environment.addMessage(existingUser, null);
		environment.addFollowing(nonExistingUser, existingUser);
		assertThat(environment.followsOf(existingUser).size(), is(0));
	}

	@Test
	public void only_existing_user_can_be_followed() {
		String existingUser = "existingUser";
		environment.addMessage(existingUser, null);
		environment.addFollowing(existingUser, "nonExisting");
		assertThat(environment.followsOf(existingUser).size(), is(0));
	}

	@Test
	public void increase_followed_list_on_every_new_follow() {
		String alice = "Alice";
		String bob = "Bob";
		String patrice = "Patrice";
		String martin = "Martin";
		String jack = "Jack";
		environment.addMessage(alice, null);
		environment.addMessage(bob, null);
		environment.addMessage(patrice, null);
		environment.addMessage(martin, null);
		environment.addMessage(jack, null);
		environment.addFollowing(alice, bob);
		environment.addFollowing(alice, patrice);
		environment.addFollowing(alice, martin);
		environment.addFollowing(alice, jack);
		assertThat(environment.followsOf(alice).size(), is(4));
	}
}
