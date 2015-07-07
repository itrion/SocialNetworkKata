package kata.socialnetwork.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wall {
	private final String owner;
	private final List<Message> newsFeed;

	public Wall(String owner, List<Message> timeline) {
		this.owner = owner;
		this.newsFeed = timeline;
	}

	public void addToNewsFeed(String other, List<Message> timeline) {
		newsFeed.addAll(timeline);
	}

	public List<Message> sortBy(Comparator<Message> comparator) {
		return new ArrayList<>();
	}
}
