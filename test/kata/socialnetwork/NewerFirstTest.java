package kata.socialnetwork;

import kata.socialnetwork.model.Message;
import kata.socialnetwork.sort.NewestFirst;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class NewerFirstTest {
	@Test
	public void when_message_has_same_time_stamp() {
		assertThat(new NewestFirst().compare(new Message(0, ""), new Message(0, "")), is(0));
	}

	@Test
	public void when_left_side_message_is_newer() {
		assertThat(new NewestFirst().compare(new Message(10, ""), new Message(0, "")), is(greaterThan(0)));
	}

	@Test
	public void when_left_side_message_is_older() {
		assertThat(new NewestFirst().compare(new Message(0, ""), new Message(10, "")), is(lessThan(0)));
	}
}
