package dmcigd;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.objects.blocks.*;
import dmcigd.core.objects.platforms.*;

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
	}
	
	public void step() {
		
		for (SolidObject i : solidObjects) {
			i.step();
		}
		
		player.step(solidObjects);
		
		if(player.isDead) {
			isDead = true;
		}
		
		fetchVisibleObjects();
		
	}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, "demo");
		environmentMap.loadEnvironmentMap(codeBase, "demo");
		
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap);
		
		solidObjects.add(new MovingPlatform(1920, 384, 1, 6, 1, 6));
		
		solidObjects.add(new MovingPlatform(1952, 480, 0, 6, 1, 6));
		
		solidObjects.add(new MovingPlatform(5184, 480, 1, 1, 1, 14));
		
		solidObjects.add(new MovingPlatform(5760, 896, 0, 8, 1, 20));
		
		solidObjects.add(new MovingPlatform(7200, 864, 0, 3, 1, 7));
		
		solidObjects.add(new TimedBlock(1312, 512, 1, 0, 100, 100));
		
		solidObjects.add(new TimedBlock(2016, 544, 4, 0, 200, 100));
		
		solidObjects.add(new TimedBlock(5184, 736, 5, 0, 300, 100));
		
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
