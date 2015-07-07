package kata.socialnetwork;

import kata.socialnetwork.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class TheSocialNetwork {
	
	private SocialNetwork instance;
	private Environment environment;
	
	@Before
	public void setUp() throws Exception {
		environment = mock(Environment.class);
		instance = new SocialNetwork(environment);
	}
	
	@Test
	public void should_allow_users_to_post_to_their_walls() {
		configureUserInput("Bob -> Damn! We lost!",
				"Bob -> Good game though.");
		ArgumentCaptor<Message> capturedMessage = ArgumentCaptor.forClass(Message.class);
		verify(environment, times(2)).addMessage(eq("Bob"), capturedMessage.capture());
		assertThat(capturedMessage.getAllValues().get(0).text(), is("Damn! We lost!"));
		assertThat(capturedMessage.getAllValues().get(1).text(), is("Good game though."));
	}
	
	@Test
	public void should_allow_to_read_a_users_timeline() {
		configureUserInput("Bob");
		verify(environment).timeline("Bob");
	}
	
	@Test
	public void should_allow_to_follow_a_user() {
		configureUserInput("Bob follows Alice");
		verify(environment).addFollowing("Bob", "Alice");
	}
	
	@Test
	public void should_allow_to_read_a_user_wall() {
		configureUserInput("Bob follows Alice",
				"Bob follows Patrice",
				"Bob wall");
		verify(environment).followsOf("Bob");
		verify(environment).timeline("Bob");
		verify(environment).timeline("Alice");
		verify(environment).timeline("Patrice");
	}
	
	private void configureUserInput(String... commands) {
		for (String command : commands) {
			instance.process(command);
		}
	}
}
