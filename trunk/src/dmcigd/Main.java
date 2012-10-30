package dmcigd;

import dmcigd.core.*;
import dmcigd.core.enums.GameState;

import java.awt.event.*;
import java.net.*;

//Catches input and manages game loop objects
public class Main implements Runnable, KeyListener {
	
	//Initialize level object
	Level level;
	
	//Initializing gameState variable - decides which object to interact with
	private GameState gameState,unpauseGameState;
	private ThreadSync threadSync;
	private URL codeBase;
	
	public Main(ThreadSync threadSync, URL codeBase) {
		
		this.codeBase = codeBase;
		
		this.threadSync = threadSync;
		
		//Set gameState variable (currently at 3 for Demo Screen, should be changed to 1 for real game to initiate start menu)
		gameState = GameState.LOADINGLEVEL;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
		level = new Demo(codeBase);
	}
	
	//Passes game state to rendering thread
	public GameState getGameState() {
		return gameState;
	}
	
	public void gameOver() {
		//Temporary measure until proper level loader is implemented
		level = new Demo(codeBase);
		gameState = GameState.LOADINGLEVEL;
	}
	
	public void pause() {
		if(gameState != GameState.PAUSE) {
			unpauseGameState = gameState;
			gameState = GameState.PAUSE;
		} else {
			gameState = unpauseGameState;
		}
	}
	
	public void run() {
		while(true) {
			
			//Listens to DmciGD thread and waits until it finishes receiving variables
			threadSync.produce();
			
			//Temporary game state, remove when done
			switch(gameState) {
				case LEVEL:
					
					if(level.isDead()) {
						gameOver();
					}else if(level.inDialogue()) {
						//Enter dialogue
						gameState = GameState.DIALOGUE;
					} else {
						level.step();
					}
					
					break;
					
				case LOADINGLEVEL:
					
					//Change gameState when level element is done loading
					if(level != null && level.isReady()) {
						gameState = GameState.LEVEL;
					}
					
					break;
					
				case DIALOGUE:
					
					if(!level.inDialogue()) {
						//Exit dialogue
						gameState = GameState.LEVEL;
					}
					
				default:
					break;
			}
			
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {}
			
			//Tells DmciGD thread that there are new variables to grab
			threadSync.produced();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		//Catch core keypresses such as Pause/Unpause

		int keyCode = e.getKeyCode();
		switch(keyCode) {
		
			case KeyEvent.VK_R:
				//Reset Level
				gameOver();
				break;
				
			case KeyEvent.VK_P:
				//Pause Game
				pause();
				break;
				
			default:

				//Pass keypresses to appropriate object
				switch(gameState) {
					case DIALOGUE:
					case LEVEL:
						level.keyPressed(e);
					default:
						break;
				}
				
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//Catch core keyreleases such as Pause/Unpause
		
		//Pass keyreleases to appropriate object
		switch(gameState) {
			case DIALOGUE:
			case LEVEL:
				level.keyReleased(e);
			default:
				break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
