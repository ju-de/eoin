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
	public final String levelName = "demo";
	public final String tileSet = "grassy";
	
	//Passes booleans to be manipulated by Main Game Loop
	private boolean ready,isDead = false;
	
	//Objects and object lists
	public Player player;
	public BlockMap blockMap = new BlockMap();
	public EnvironmentMap environmentMap = new EnvironmentMap();
	public ArrayList<ObjectImage> visibleObjects;
	public ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	private Iterator<SolidObject> solidObjectIt;
	public ArrayList<Item> items = new ArrayList<Item>();
	private Iterator<Item> itemIt;
	public ArrayList<SolidObject> projectiles = new ArrayList<SolidObject>();
	private Iterator<SolidObject> projectileIt;
	public ArrayList<Region> regions = new ArrayList<Region>();
	
	//Dialogue Handler
	public DialogueHandler dialogueHandler = new DialogueHandler();
	
	public boolean isReady() {
		return ready;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public boolean inDialogue() {
		return dialogueHandler.inDialogue;
	}
	
	public Room(URL codeBase) {
		this.codeBase = codeBase;
		
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
		
		fetchVisibleObjects();
		
	}
	
	public void initializeSolidObjects() {}
	
	public void initializeNonsolidObjects() {}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, "demo");
		environmentMap.loadEnvironmentMap(codeBase, "demo");
		
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap, solidObjects, items, regions);
		
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
					dialogueHandler.progressDialogue();
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
