package kata.socialnetwork.model;

import kata.socialnetwork.MessageFormatter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Wall {
	private final List<MessageView> newsFeed;
	private MessageFormatter formatter;
	
	public Wall(String owner, List<Message> timeline) {
		this.newsFeed = new ArrayList<>();
		addToNewsFeed(owner, timeline);
	}
	
	public void setFormatter(MessageFormatter formatter) {
		this.formatter = formatter;
	}
	
	public void addToNewsFeed(String otherUser, List<Message> timeline) {
		timeline.forEach(addToNewsFeed(otherUser));
	}
	
	private Consumer<Message> addToNewsFeed(String owner) {
		return (message) -> newsFeed.add(new MessageView(owner, message));
	}
	
	public String sortedBy(Comparator<Message> comparator) {
		newsFeed.sort(new MessageViewComparator(comparator));
		StringBuilder result = new StringBuilder();
		for (MessageView messageView : newsFeed) {
			result.append(messageView.format(formatter)).append('\n');
		}
		return result.toString();
	}
	
	private class MessageView {
		private final String owner;
		private final Message message;
		
		public MessageView(String owner, Message message) {
			this.owner = owner;
			this.message = message;
		}
		
		public Message message() {
			return message;
		}

		public String format(MessageFormatter formatter) {
			return owner + " - " + formatter.format(message);
		}
	}
	
	private class MessageViewComparator implements Comparator<MessageView> {
		private final Comparator<Message> delegate;

		public MessageViewComparator(Comparator<Message> comparator) {
			this.delegate = comparator;
		}
		
		@Override
		public int compare(MessageView lhs, MessageView rhs) {
			return delegate.compare(lhs.message(), rhs.message());
		}
	}
}
