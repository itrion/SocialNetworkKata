package kata.socialnetwork.view;

import kata.socialnetwork.model.Message;

import java.util.Comparator;

public class MessageViewComparator implements Comparator<MessageView> {
	private final Comparator<Message> delegate;

	public MessageViewComparator(Comparator<Message> comparator) {
		this.delegate = comparator;
	}

	@Override
	public int compare(MessageView lhs, MessageView rhs) {
		return delegate.compare(lhs.message(), rhs.message());
	}
}
