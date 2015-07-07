package kata.socialnetwork.commands;

import java.util.*;
import java.util.function.BiFunction;

public class CommandFactory {
	private static Map<String, BiFunction<String, Deque<String>, Command>> commands = new HashMap<>();

	static {
		commands.put("->", (callerName, input) -> {
			String text = input.stream().reduce("", (current, next) -> current += " " + next).trim();
			return new PostToWall(callerName, text);
		});
	}
	
	public static Command create(String rawInput) {
		Deque<String> input = new ArrayDeque<>(Arrays.asList(rawInput.split(" ")));
		String callerName = input.poll();
		String command = "" + input.poll();
		if (command.contains("->")) return commands.get(command).apply(callerName, input);
		if (command.contains("follows")) return new FollowUser(callerName, "");
		if (command.contains("wall")) return new ReadWall(callerName, null);
		else return new ReadTimeline(callerName, null);
	}
}
