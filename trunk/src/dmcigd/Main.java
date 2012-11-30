package dmcigd;

import dmcigd.core.*;
import dmcigd.core.enums.GameState;
import dmcigd.core.room.Room;

import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

//Catches input and manages game loop objects
public class Main implements Runnable, KeyListener {
	
	//Initialize level object
	public Room room;
	
	//Initialize decayState variables
	private boolean decayState = false;
	private int killCount = 0;
	private int maxKillCount = 1000;
	private int decayTimer = 0;
	private int decayLimit = maxKillCount;
	
	//Initializing gameState variable - decides which object to interact with
	private GameState gameState,unpauseGameState;
	
	//Initialize game constants
	private ThreadSync threadSync;
	private URL codeBase;
	
	private String currentRoom;
	
	//Public Getters
	public GameState getGameState() {
		return gameState;
	}
	public boolean getDecayState() {
		return decayState;
	}
	public Room getRoom() {
		return room;
	}
	
	public int getKillCount() {
		return killCount;
	}
	
	public Main(ThreadSync threadSync, URL codeBase) {
		
		this.codeBase = codeBase;
		
		this.threadSync = threadSync;
		
		gameState = GameState.LOADINGROOM;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
		loadRoom("game.MainMenu");
	}
	
	public void loadRoom(String roomName) {
		try {
			room = (Room) Class.forName("dmcigd.levels."+roomName).getConstructor(URL.class).newInstance(codeBase);

			gameState = GameState.LOADINGROOM;
			
			currentRoom = roomName;
				
		} catch (InstantiationException e) {e.printStackTrace();} 
		catch (IllegalAccessException e) {e.printStackTrace();} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (IllegalArgumentException e) {e.printStackTrace();} 
		catch (InvocationTargetException e) {e.printStackTrace();} 
		catch (NoSuchMethodException e) {e.printStackTrace();} 
		catch (SecurityException e) {e.printStackTrace();}
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
					} else if(room.getDialogueHandler().inDialogue()) {
						gameState = GameState.DIALOGUE;
					} else if(room.getTargetRoom() != null) {
						killCount += room.getPlayer().sword.getKillCount();
						loadRoom(room.getTargetRoom());
					} else {
						room.step();
						
						//Determine decay state:
						decayTimer++;
						int curKillCount = killCount + room.getPlayer().sword.getKillCount();
						if(decayTimer >= decayLimit) {
							if(decayState) {
								decayState = false;
								decayLimit = (maxKillCount - curKillCount) +							//Base Timer
											 ((int)(Math.random() * (maxKillCount - curKillCount)));	//Random addition
							} else {
								decayState = true;
								decayLimit = ((int)(Math.random() * curKillCount));
							}
							decayTimer = 0;
						}
						
					}
					
					break;
					
				case LOADINGROOM:
					
					//Change gameState when level element is done loading
					if(room != null && room.isReady()) {
						gameState = GameState.GAMEPLAY;
						MidiPlayer.endSong();
						MidiPlayer.startSong(room.getLevelName()+".mid", codeBase);
					}
					
					break;
					
				case DIALOGUE:
					
					if(!room.getDialogueHandler().inDialogue()) {
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
		
		//Catch core keypresses relating to the core game loop.

		int keyCode = e.getKeyCode();
		switch(keyCode) {
		
			case KeyEvent.VK_Q:
				//Quit Game
				loadRoom("game.MainMenu");
				killCount = 0;
				break;
		
			case KeyEvent.VK_R:
				//Reset Level
				loadRoom(currentRoom);
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
				
				//Passes KeyEvent to room instance
				if(gameState == GameState.DIALOGUE || gameState == GameState.GAMEPLAY) {
					room.keyPressed(e);
				}
				
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//Passes KeyEvent to room instance
		if(gameState == GameState.DIALOGUE || gameState == GameState.GAMEPLAY) {
			room.keyReleased(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
