package kata.socialnetwork;

import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.prettytime.units.JustNow;

import java.util.Date;
import java.util.List;

public class MessageFormatter {
	
	private PrettyTime prettyTime;
	
	public MessageFormatter() {
		prettyTime = new PrettyTime();
		prettyTime.getUnit(JustNow.class).setMaxQuantity(1000);
	}
	
	public String format(List<Message> messages) {
		StringBuilder builder = new StringBuilder();
		for (Message message : messages) {
			builder.append(format(message)).append('\n');
		}
		return builder.toString();
	}

	public String format(Message message) {
		return message.text() + " (" + relativeTime(message.timestamp()) + ")";
	}

	private String relativeTime(long timestamp) {
		return prettyTime.format(new Date(timestamp));
	}
}
