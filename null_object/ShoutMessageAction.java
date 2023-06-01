public class ShoutMessageAction implements MessageAction {
	public void sendMessage(String message) {
		// print it, but really loudly
		System.out.println(message.toUpperCase());
	}
}
