package dmcigd;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.player.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Demo implements Runnable {
	
	//Stores codeBase string to be passed for file loading
	private URL codeBase;
	
	private boolean ready = false;
	public Player player;
	public BlockMap blockMap = new BlockMap();
	public String levelName = "demo";
	
	public boolean isReady() {
		return ready;
	}
	
	public Demo(URL codeBase) {
		this.codeBase = codeBase;
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void step() {
		
		player.step();
		
	}
	
	public void run() {
		
		blockMap.loadBlockMap(codeBase, "demo");
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap);
		
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
