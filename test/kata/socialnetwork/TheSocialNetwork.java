package kata.socialnetwork;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

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
		
		verify(environment, times(2)).addMessage(anyString(), Matchers.<Message>any());
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
		verify(environment).follows("Bob");
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
