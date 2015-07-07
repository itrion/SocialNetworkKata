package kata.socialnetwork.model;

import kata.socialnetwork.MessageFormatter;
import kata.socialnetwork.view.MessageView;
import kata.socialnetwork.view.MessageViewComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		newsFeed.addAll(timeline
				.stream()
				.map(message -> new MessageView(otherUser, message))
				.collect(Collectors.toList()));
	}
	
	public String sortedBy(Comparator<Message> comparator) {
		newsFeed.sort(new MessageViewComparator(comparator));
		StringBuilder result = new StringBuilder();
		for (MessageView messageView : newsFeed) {
			result.append(messageView.format(formatter)).append('\n');
		}
		return result.toString();
	}
}
