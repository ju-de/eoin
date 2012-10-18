package dmcigd;

import dmcigd.core.*;
import dmcigd.core.objects.player.*;
import java.awt.event.*;

public class Demo implements Runnable {
	
	private boolean ready = false;
	public Player player;
	public BlockLoader blockLoader = new BlockLoader();
	
	public boolean isReady() {
		return ready;
	}
	
	public Demo() {
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void step() {
		
		player.step(blockLoader.getImmediateBlocks(player.getX(), player.getY()));
		blockLoader.fetchVisibleBlocks(player.getX(), player.getY());
		
	}
	
	public void run() {
		
		blockLoader.loadBlockMap("demo");
		player = new Player(blockLoader.getSpawnX() * 32, blockLoader.getSpawnY() * 32);
		
		ready = true;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				//Just testing acceleration. Replace this command later
				player.setAX(-3);
				break;
			case KeyEvent.VK_DOWN:
				//Just testing acceleration. Remove this command later
				player.setAX(3);
				break;
			case KeyEvent.VK_LEFT:
				player.setVX(-3);
				break;
			case KeyEvent.VK_RIGHT:
				player.setVX(3);
				break;
			case KeyEvent.VK_Z:
				player.setVY(-3);
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.setVY(2);
				break;
			case KeyEvent.VK_LEFT:
				player.setVX(0);
				break;
			case KeyEvent.VK_RIGHT:
				player.setVX(0);
				break;
			case KeyEvent.VK_Z:
				player.setVY(2);
				break;
			default:
				break;
		}
	}
}
