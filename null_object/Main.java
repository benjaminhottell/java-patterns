public class Main {

	public static void main(String[] args) {
		demo(new PrintMessageAction());
		demo(new ShoutMessageAction());
		demo(new NullMessageAction());
	}

	public static void demo(MessageAction a) {
		String msg = "Message to send";
		a.sendMessage(msg);
	}

}
