package dmcigd;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.player.*;

import java.awt.event.*;
import java.net.*;
import java.util.*;

public class Demo implements Runnable {
	
	//Stores codeBase string to be passed for file loading
	private URL codeBase;
	
	//Level information
	public final String levelName = "demo";
	public final String tileSet = "demo";
	
	//Passes booleans to be manipulated by Main Game Loop
	private boolean ready,isDead = false;
	
	//Objects and object lists
	public Player player;
	public BlockMap blockMap = new BlockMap();
	public EnvironmentMap environmentMap = new EnvironmentMap();
	public ArrayList<ObjectImage> visibleSolidObjects;
	
	public boolean isReady() {
		return ready;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public Demo(URL codeBase) {
		this.codeBase = codeBase;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void step() {
		
		player.step();
		if(player.isDead) {
			isDead = true;
		}
		
		visibleSolidObjects = new ArrayList<ObjectImage>();
		
	}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, "demo");
		environmentMap.loadEnvironmentMap(codeBase, "demo");
		
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap);
		
		visibleSolidObjects = new ArrayList<ObjectImage>();
		
		ready = true;
		
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.climbUp(true);
				break;
			case KeyEvent.VK_DOWN:
				player.keyDown(true);
				break;
			case KeyEvent.VK_LEFT:
				player.walk(true, Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				player.walk(true, Direction.RIGHT);
				break;
			case KeyEvent.VK_Z:
				player.jump(true);
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.climbUp(false);
				break;
			case KeyEvent.VK_DOWN:
				player.keyDown(false);
				break;
			case KeyEvent.VK_LEFT:
				player.walk(false, Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				player.walk(false, Direction.RIGHT);
				break;
			case KeyEvent.VK_Z:
				player.jump(false);
				break;
			default:
				break;
		}
	}
}
