package dmcigd.core;

import java.awt.*;
import java.applet.*;
import dmcigd.core.ObjectBroker;
import dmcigd.core.Demo;

// Starting point for the game, initializes applet
public abstract class Game extends Applet implements Runnable {
	public static enum GameState {
		OVER, PAUSED, DIALOGUE, MENU, ACTIVE, DEMO
	} // Possible game states (game over, paused, in dialogue, in menu, gameplay and in demo)
	private static GameState initialGameState;
	private static GameState currentGameState;
	// Canvas dimentions
	private static int appletWidth;
	private static int appletHeight;
	// handler objects and threads
	private static ObjectBroker objectBroker; // The object-handling object.
	private static Thread objectBrokerThread; // The main object-handling thread.
	private static Thread displayThread; // The main rendering thread.
	public static Demo demo; // placeholder until further development

	public static GameState getInitialGameState() {
		return initialGameState;
	}
	public static GameState getCurrentGameState() {
		return currentGameState;
	}
	public static void setCurrentGameState(GameState state) {
		currentGameState = state;
	}

	public static ObjectBroker getObjectBroker() {
		return objectBroker;
	}
	public static Thread getObjectBrokerThread() {
		return objectBrokerThread;
	}
	public static Thread getDisplayThread() {
		return displayThread;
	}

	public static int getAppletWidth() {
		return appletWidth;
	}
	public static int getAppletHeight() {
		return appletHeight;
	}

	// initialize game objects and threads
	public void init() {
					// initialize members
		initialGameState = GameState.DEMO;
		appletWidth = 640;
		appletHeight = 320;
		demo = new Demo(); // placeholder pending further development
			objectBroker = new ObjectBroker(demo);
			objectBrokerThread = new Thread(objectBroker);
			displayThread = new Thread(this);
		setCurrentGameState(initialGameState);
		setBackground (Color.black); 
		addKeyListener(objectBroker.getInputHandler());
	}

	//Starts thread
	public void start () {
		// start the main threads
		objectBrokerThread.start();
		displayThread.start();
	}
	public abstract void run();
	public abstract void update(Graphics g);
	public abstract void paint(Graphics g);
}
