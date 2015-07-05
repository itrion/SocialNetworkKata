package kata.socialnetwork;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TheSocialNetwork {
	@Test
	public void should_allow_users_to_post_to_their_walls() {
		String[] commands = new String[]{
				"Bob -> Damn! We lost!",
				"Bob -> Good game though."};
		
		SocialNetwork instance = new SocialNetwork();
		for (String command : commands) {
			instance.process(command);
		}
		
		List<Message> bobMessages = instance.wall("Bob");
		assertThat(bobMessages.size(), is(2));
		assertThat(bobMessages.get(0).text(), is("Damn! We lost!"));
		assertThat(bobMessages.get(1).text(), is("Good game though."));
	}
}
