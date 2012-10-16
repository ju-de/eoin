package dmcigd;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//Catches input and manages game loop objects
public class Main implements Runnable, KeyListener {
	
	//Initialize Demo Thread (temporary, delete when game is ready)
	Demo demo;
	
	//Initializing gameState variable - decides which object to interact with
	private int gameState;
	
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();
	
	public Main() {
		
		//Set gameState variable (currently at 3 for Demo Screen, should be changed to 1 for real game to initiate start menu)
		gameState = 3;
		
		//Start Demo Thread (temporary, remove when game is ready)
		demo = new Demo();
		visibleObjects.add((int) 1);
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
	}
	
	//Passes game state to rendering thread
	public int getGameState() {
		return gameState;
	}
	
	public ArrayList getVisibleObjects() {
		return visibleObjects;
	}
	
	public void start() {
		
	}
	
	public void run() {
		while(true) {
			//Temporary game state, remove when done
			if(gameState == 3) {
				visibleObjects.set(0, (int) demo.getX());
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		//Catch core keypresses such as Pause/Unpause
		
		//Pass keypresses to appropriate object
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
