package kata.socialnetwork;

import java.io.*;

import static kata.socialnetwork.commands.CommandFactory.create;

public class SocialNetwork {
	private final Environment environment;
	
	public SocialNetwork(Environment environment) {
		this.environment = environment;
	}
	
	public static void main(String[] args) throws IOException {
		new SocialNetwork(new Environment()).run(System.in, System.out);
	}
	
	private void run(InputStream inStream, PrintStream outStream) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
		PrintStream output = new PrintStream(outStream);
		while (true) {
			output.print(process(input.readLine()));
		}
	}

	public String process(String input) {
		return create(input).execute(environment);
	}
}
