import java.io.PrintStream;

// This class allows you to intercept everything written to stdout
// (System.out). Because there is only one stdout that is shared throughout the
// entire process, putting this into an object that can be instantiated
// multiple times doesn't make much sense.

// This is not thread safe.

public final class StdoutInterceptor {

	// prevents instantiating this class
	private StdoutInterceptor() {
	}

	private static PrintStream keptStdout = null;

	public static boolean isIntercepting() {
		return keptStdout != null;
	}

	public static void startIntercepting(PrintStream interceptor) {
		if (isIntercepting()) {
			throw new IllegalStateException("Already intercepting stdout");
		}
		keptStdout = System.out;
		System.setOut(interceptor);
	}

	public static void startDiscarding() {
		startIntercepting(new PrintStream(new NullOutputStream()));
	}

	public static void stopIntercepting() {
		if (!isIntercepting()) {
			throw new IllegalStateException("Not intercepting stdout");
		}
		System.setOut(keptStdout);
		keptStdout = null;
	}

}
