package dmcigd.core;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.player.*;

import java.awt.event.*;
import java.net.*;
import java.util.*;

public class Room implements Runnable {
	
	//Stores codeBase string to be passed for file loading
	private URL codeBase;
	
	//Default level information
	public String levelName,roomName,tileSet;
	
	//Passes variables to be read by Main Game Loop
	private boolean ready,isDead = false;
	private String level,room;
	
	//Objects and object lists
	public Player player;
	public BlockMap blockMap = new BlockMap();
	public EnvironmentMap environmentMap = new EnvironmentMap();
	public ArrayList<TextLabel> textLabels = new ArrayList<TextLabel>();
	public ArrayList<ObjectImage> visibleObjects;
	public ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	private Iterator<SolidObject> solidObjectIt;
	public ArrayList<Item> items = new ArrayList<Item>();
	private Iterator<Item> itemIt;
	public ArrayList<SolidObject> projectiles = new ArrayList<SolidObject>();
	private Iterator<SolidObject> projectileIt;
	public ArrayList<Region> regions = new ArrayList<Region>();
	
	//Dialogue Handler
	public DialogueHandler dh = new DialogueHandler();
	
	public boolean isReady() {
		return ready;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public String getLevel() {
		return level;
	}
	
	public String getRoom() {
		return room;
	}
	
	public boolean inDialogue() {
		return dh.inDialogue();
	}
	
	public Room(URL codeBase, String levelName, String roomName, String tileSet) {
		this.codeBase = codeBase;
		this.levelName = levelName;
		this.roomName = roomName;
		this.tileSet = tileSet;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void fetchVisibleObjects() {
		
		visibleObjects = new ArrayList<ObjectImage>();

		for (Region i : regions) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
		
		for (SolidObject i : solidObjects) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
		
		visibleObjects.add(player.getObjectImage(player.getX(), player.getY()));
		
		for (Item i : items) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
		
		for (SolidObject i : projectiles) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
	}
	
	public void step() {
		
		//Step all projectiles
		projectileIt = projectiles.iterator();
		
		while(projectileIt.hasNext()) {
			SolidObject i = projectileIt.next();
			if(i.isDestroyed()) {
				projectileIt.remove();
			} else {
				i.step();
			}
		}
		
		//Step all solid objects and player
		solidObjectIt = solidObjects.iterator();
		
		while(solidObjectIt.hasNext()) {
			SolidObject i = solidObjectIt.next();
			if(i.isDestroyed()) {
				solidObjectIt.remove();
			} else {
				i.step();
			}
		}
		
		if(player.isDead || player.isDestroyed) {
			isDead = true;
		}
		
		//Step all items
		itemIt = items.iterator();
		
		while(itemIt.hasNext()) {
			Item i = itemIt.next();
			if(i.isDestroyed()) {
				itemIt.remove();
			} else {
				i.step();
			}
		}
		
		//Step all regions
		for (Region i : regions) {
			i.step();
		}
		
		//Check for level advancement
		if(player.getRoom() != null) {
			level = player.getLevel();
			room = player.getRoom();
		}
		
		fetchVisibleObjects();
		
	}
	
	public void initializeSolidObjects() {}
	
	public void initializeNonsolidObjects() {}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, levelName, roomName);
		environmentMap.loadEnvironmentMap(codeBase, levelName, roomName);
		
		player = new Player(blockMap.getSpawnX() * 32 + 6, blockMap.getSpawnY() * 32, blockMap, solidObjects, items, regions);
		
		initializeSolidObjects();
		
		solidObjects.add(player);
		
		initializeNonsolidObjects();

		fetchVisibleObjects();
		
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
			case KeyEvent.VK_X:
				if(inDialogue()) {
					dh.advance();
				} else {
					player.interact();
				}
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
