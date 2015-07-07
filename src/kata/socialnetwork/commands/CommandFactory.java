package kata.socialnetwork.commands;

import kata.socialnetwork.MessageFormatter;

import java.util.*;
import java.util.function.BiFunction;

public class CommandFactory {
	private static Map<String, BiFunction<String, Deque<String>, Command>> commands = new HashMap<>();

	static {
		commands.put("->", (callerName, input) -> {
			String text = input.stream().reduce("", (current, next) -> current += " " + next).trim();
			return new PostToWall(callerName, text);
		});
		commands.put("follows", (callerName, input) -> new FollowUser(callerName, input.removeFirst()));
		commands.put("wall", (callerName, input) -> new ReadWall(callerName, new MessageFormatter()));
		commands.put("timeline", (callerName, input) -> new ReadTimeline(callerName, new MessageFormatter()));
	}
	
	public static Command createFrom(String rawInput) {
		Deque<String> input = new ArrayDeque<>(Arrays.asList(rawInput.split(" ")));
		String callerName = input.poll();
		return commands.get(fixEmpty(input.poll())).apply(callerName, input);
	}

	private static String fixEmpty(String command) {
		return command != null ? command : "timeline";
	}
}
