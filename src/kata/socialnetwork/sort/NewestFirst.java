package kata.socialnetwork.sort;

import kata.socialnetwork.model.Message;

import java.util.Comparator;

public class NewestFirst implements Comparator<Message> {
	@Override
	public int compare(Message lhs, Message rhs) {
		return (int) (lhs.timestamp() - rhs.timestamp());
	}
}
