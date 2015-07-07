package kata.socialnetwork;

import kata.socialnetwork.commands.CommandFactory;

import java.io.*;

public class SocialNetwork {
	private final Environment environment;
	
	public static void main(String[] args) throws IOException {
		new SocialNetwork(new Environment()).run(System.in, System.out);
	}

	public SocialNetwork(Environment environment) {
		this.environment = environment;
	}

	@SuppressWarnings("InfiniteLoopStatement")
	private void run(InputStream inStream, PrintStream outStream) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
		PrintStream output = new PrintStream(outStream);
		while (true) {
			output.print(process(input.readLine()));
		}
	}

	public String process(String input) {
		return CommandFactory.createFrom(input).execute(environment);
	}
}
