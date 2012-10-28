package dmcigd;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;
import dmcigd.core.objects.items.*;

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
	public ArrayList<ObjectImage> visibleObjects;
	public ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	private Iterator<SolidObject> solidObjectIt;
	public ArrayList<Item> items = new ArrayList<Item>();
	private Iterator<Item> itemIt;
	
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
	
	public void fetchVisibleObjects() {
		
		visibleObjects = new ArrayList<ObjectImage>();
		
		visibleObjects.add(player.getObjectImage(player.getX(), player.getY()));
		
		for (SolidObject i : solidObjects) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
		
		for (Item i : items) {
			if(i.isVisible(player.getX(), player.getY())) {
				visibleObjects.add(i.getObjectImage(player.getX(), player.getY()));
			}
		}
	}
	
	public void step() {
		
		solidObjectIt = solidObjects.iterator();
		
		while(solidObjectIt.hasNext()) {
			SolidObject i = solidObjectIt.next();
//			if(i.isDestroyed()) {
//				it.remove();
//			} else {
				i.step();
//			}
		}
		
		itemIt = items.iterator();
		
		while(itemIt.hasNext()) {
			Item i = itemIt.next();
			if(i.isUsed()) {
				itemIt.remove();
			} else {
				i.step();
			}
		}
				
		if(player.isDead) {
			isDead = true;
		}
		
		fetchVisibleObjects();
		
	}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, "demo");
		environmentMap.loadEnvironmentMap(codeBase, "demo");
		
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap, solidObjects, items);
		
		solidObjects.add(new PushableBlock(832, 480, blockMap, solidObjects));

		solidObjects.add(new LockedDoor(992, 480, 1));
		
		solidObjects.add(new LockedDoor(1088, 480, 2));
		
		solidObjects.add(new MovingPlatform(1920, 384, 1, 6, 1, 6));
		
		solidObjects.add(new MovingPlatform(1952, 480, 0, 6, 1, 6));
		
		solidObjects.add(new PushableBlock(2048, 416, blockMap, solidObjects));
		
		solidObjects.add(new MovingPlatform(5184, 480, 1, 1, 1, 14));
		
		solidObjects.add(new MovingPlatform(5760, 896, 0, 8, 1, 20));
		
		solidObjects.add(new MovingPlatform(7200, 864, 0, 3, 1, 7));
		
		solidObjects.add(new CrumblingBlock(960, 256, 0.15f, 500));
		
		solidObjects.add(new TimedBlock(1312, 512, 1, 0, 100, 100));
		
		solidObjects.add(new CrumblingBlock(2016, 544, 0.15f, 500));
		solidObjects.add(new CrumblingBlock(2048, 544, 0.15f, 500));
		solidObjects.add(new CrumblingBlock(2080, 544, 0.15f, 500));
		solidObjects.add(new CrumblingBlock(2112, 544, 0.15f, 500));
		
		//solidObjects.add(new TimedBlock(2016, 544, 4, 0, 200, 100));
		
		solidObjects.add(new TimedBlock(5184, 736, 5, 0, 300, 100));
		
		solidObjects.add(new CrumblingBlock(5792, 448, 0.15f, 500));
		
		solidObjects.add(new CrumblingBlock(5952, 416, 0.15f, 500));
		
		solidObjects.add(new TimedBlock(180 * 32, 704, 1, 17 * 16, 32, 288));
		solidObjects.add(new TimedBlock(181 * 32, 704, 1, 16 * 16, 32, 288));
		solidObjects.add(new TimedBlock(182 * 32, 704, 1, 15 * 16, 32, 288));
		solidObjects.add(new TimedBlock(183 * 32, 704, 1, 14 * 16, 32, 288));
		solidObjects.add(new TimedBlock(184 * 32, 704, 1, 13 * 16, 32, 288));
		solidObjects.add(new TimedBlock(185 * 32, 704, 1, 12 * 16, 32, 288));
		solidObjects.add(new TimedBlock(186 * 32, 704, 1, 11 * 16, 32, 288));
		solidObjects.add(new TimedBlock(187 * 32, 704, 1, 10 * 16, 32, 288));
		solidObjects.add(new TimedBlock(188 * 32, 704, 1, 9 * 16, 32, 288));
		solidObjects.add(new TimedBlock(189 * 32, 704, 1, 8 * 16, 32, 288));
		solidObjects.add(new TimedBlock(190 * 32, 704, 1, 7 * 16, 32, 288));
		solidObjects.add(new TimedBlock(191 * 32, 704, 1, 6 * 16, 32, 288));
		solidObjects.add(new TimedBlock(192 * 32, 704, 1, 5 * 16, 32, 288));
		solidObjects.add(new TimedBlock(193 * 32, 704, 1, 4 * 16, 32, 288));
		solidObjects.add(new TimedBlock(194 * 32, 704, 1, 3 * 16, 32, 288));
		solidObjects.add(new TimedBlock(195 * 32, 704, 1, 2 * 16, 32, 288));
		solidObjects.add(new TimedBlock(196 * 32, 704, 1, 16, 32, 288));
		solidObjects.add(new TimedBlock(197 * 32, 704, 1, 0, 32, 288));
		
		solidObjects.add(player);
		
		items.add(new DoorKey(416, 416, 1, blockMap, solidObjects));
		items.add(new DoorKey(736, 416, 2, blockMap, solidObjects));

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
			case KeyEvent.VK_C:
				player.interact();
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
