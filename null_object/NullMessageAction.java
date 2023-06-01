/*
The null message action does nothing, implicitly discarding the message.
*/

public class NullMessageAction implements MessageAction {
	public void sendMessage(String message) {
		// do nothing!
	}
}

