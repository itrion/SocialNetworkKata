package kata.socialnetwork;

import org.junit.Test;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MessageFormatterTest {
	@Test
	public void format_when_seconds_ago() {
		MessageFormatter formatter = new MessageFormatter();
		assertThat(formatter.format(new Message(currentTimeMillis() - 1000, "text")), is("text (1 second ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - 2000, "text")), is("text (2 seconds ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - 20000, "text")), is("text (20 seconds ago)"));
	}
	
	@Test
	public void format_when_minutes_ago() {
		MessageFormatter formatter = new MessageFormatter();
		assertThat(formatter.format(new Message(currentTimeMillis() - 1000 * 60, "text")), is("text (1 minute ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - 180000, "text")), is("text (3 minutes ago)"));
	}
	
	@Test
	public void format_when_hours_ago() {
		MessageFormatter formatter = new MessageFormatter();
		assertThat(formatter.format(new Message(currentTimeMillis() - 3600000, "text")), is("text (1 hour ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - 7200000, "text")), is("text (2 hours ago)"));
	}

	@Test
	public void format_when_days_ago() {
		MessageFormatter formatter = new MessageFormatter();
		assertThat(formatter.format(new Message(currentTimeMillis() - Math.round(8.64e+7), "text")), is("text (1 day ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - Math.round(8.64e+7 * 2), "text")), is("text (2 days ago)"));
	}

	@Test
	public void format_when_years_ago() {
		MessageFormatter formatter = new MessageFormatter();
		assertThat(formatter.format(new Message(currentTimeMillis() - Math.round(3.15569e10 + 1000 * 60 * 60), "text")), is("text (1 year ago)"));
		assertThat(formatter.format(new Message(currentTimeMillis() - Math.round(3.15569e10 * 2), "text")), is("text (2 years ago)"));
	}
}
