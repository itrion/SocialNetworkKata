package kata.socialnetwork.model;

public class Message {
	private final long timestamp;
	private final String text;

	public Message(long timestamp, String text) {
		this.timestamp = timestamp;
		this.text = text;
	}

	public String text() {
		return text;
	}

	public long timestamp() {
		return timestamp;
	}
}
