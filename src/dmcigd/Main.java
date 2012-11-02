package dmcigd;

import dmcigd.core.*;
import dmcigd.core.enums.GameState;

import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

//Catches input and manages game loop objects
public class Main implements Runnable, KeyListener {
	
	//Initialize level objects
	public Room room;
	
	//Initialize decayState variables
	public boolean decayState = false;
	private int killCount = 1;
	private int maxKillCount = 1000;
	private int decayTimer = 0;
	private int decayLimit = maxKillCount;
	
	//Initializing gameState variable - decides which object to interact with
	private GameState gameState,unpauseGameState;
	private ThreadSync threadSync;
	private URL codeBase;
	
	private String currentLevel,currentRoom;
	
	
	public void loadRoom(String levelName, String roomClass) {
		try {
			room = (Room) Class.forName("dmcigd.levels."+levelName+"."+roomClass).getConstructor(URL.class).newInstance(codeBase);
			
			gameState = GameState.LOADINGROOM;
			
			currentLevel = levelName;
			currentRoom = roomClass;
				
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
	}
	
	public Main(ThreadSync threadSync, URL codeBase) {
		
		this.codeBase = codeBase;
		
		this.threadSync = threadSync;
		
		gameState = GameState.LOADINGROOM;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
		currentLevel = "game";
		currentRoom = "MainMenu";
		
		loadRoom(currentLevel,currentRoom);
	}
	
	//Passes game state to rendering thread
	public GameState getGameState() {
		return gameState;
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
				case GAMEPLAY:
					
					if(room.isDead()) {
						gameState = GameState.GAMEOVER;
					} else if(room.inDialogue()) {
						gameState = GameState.DIALOGUE;
					} else if(room.getRoom() != null) {
						loadRoom(room.getLevel(), room.getRoom());
					} else {
						room.step();
						
						//Determine decay state:
						if(killCount < maxKillCount) {
							decayTimer++;
							if(decayTimer == decayLimit) {
								if(decayState) {
									decayState = false;
									decayLimit = maxKillCount - killCount + (int)(Math.random() * (maxKillCount - killCount));
								} else {
									decayState = true;
									decayLimit = 1 + (int)(Math.random() * killCount);
								}
								decayTimer = 0;
							}
						} else {
							decayState = true;
						}
						
					}
					
					break;
					
				case LOADINGROOM:
					
					//Change gameState when level element is done loading
					if(room != null && room.isReady()) {
						gameState = GameState.GAMEPLAY;
					}
					
					break;
					
				case DIALOGUE:
					
					if(!room.inDialogue()) {
						//Exit dialogue
						gameState = GameState.GAMEPLAY;
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
				loadRoom(currentLevel,currentRoom);
				break;
				
			case KeyEvent.VK_P:
				//Pause Game
				pause();
				break;
				
			case KeyEvent.VK_T:
				//Decay Test
				killCount++;
				System.out.println(killCount);
				break;
				
			default:

				//Pass keypresses to appropriate object
				switch(gameState) {
					case DIALOGUE:
					case GAMEPLAY:
						room.keyPressed(e);
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
			case GAMEPLAY:
				room.keyReleased(e);
			default:
				break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
