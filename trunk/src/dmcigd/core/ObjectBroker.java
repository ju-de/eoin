package dmcigd.core;

import java.awt.event.KeyAdapter;

public class ObjectBroker implements Runnable {
	private class InputHandler extends KeyAdapter {
	}
	public ObjectBroker(Object level) {
	}
	public InputHandler getInputHandler() {
		return new InputHandler();
	}
	public void run() {
	}
}
