package dmcigd;

import dmcigd.core.*;

import java.awt.event.*;

//Catches input and manages game loop objects
public class Main implements Runnable, KeyListener {
	
	//Initialize Demo Thread (temporary, delete when game is ready)
	Demo demo;
	
	//Initializing gameState variable - decides which object to interact with
	private GameState gameState;
	private ThreadSync threadSync;
	
	public Main(ThreadSync threadSync) {
		this.threadSync = threadSync;
		
		//Set gameState variable (currently at 3 for Demo Screen, should be changed to 1 for real game to initiate start menu)
		gameState = GameState.LOADINGDEMO;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
		demo = new Demo();
	}
	
	//Passes game state to rendering thread
	public GameState getGameState() {
		return gameState;
	}
	
	public void run() {
		while(true) {
			
			threadSync.produce();
			
			//Temporary game state, remove when done
			switch(gameState) {
				case DEMO:
					demo.step();
					break;
				case LOADINGDEMO:
					
					//Change gameState when level element is done loading
					if(demo != null && demo.isReady()) {
						gameState = GameState.DEMO;
					}
					
					break;
				default:
					break;
			}
			
			threadSync.produced();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		//Catch core keypresses such as Pause/Unpause
		
		//Pass keypresses to appropriate object
		switch(gameState) {
			case DEMO:
				demo.keyPressed(e);
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//Catch core keyreleases such as Pause/Unpause
		
		//Pass keyreleases to appropriate object
		switch(gameState) {
			case DEMO:
				demo.keyReleased(e);
			default:
				break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
