package withClient;

import java.io.IOException;

public class ShutDown {
	public static void main(String[] args) throws IOException {
		Runtime run = Runtime.getRuntime();
		Process proc = run.exec("shutdown -s -t 1");
	}
}
