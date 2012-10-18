package dmcigd;

import dmcigd.core.BlockLoader;
import java.awt.event.*;
import java.util.ArrayList;

public class Demo extends BlockLoader implements Runnable {
	
	private boolean ready = false;
	
	public boolean isReady() {
		return ready;
	}
	
	public int getDemoX() {
		return demoX;
	}
	
	public int getDemoY() {
		return demoY;
	}
	
	public Demo() {
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void step() {
		
		demoX = demoX + demoDX;
		demoY = demoY + demoDY;
		
		fetchVisibleBlocks();
		
	}
	
	public void run() {
		
		loadBlockMap("demo");
		
		ready = true;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				demoDY = -1;
				break;
			case KeyEvent.VK_DOWN:
				demoDY = 1;
				break;
			case KeyEvent.VK_LEFT:
				demoDX = -1;
				break;
			case KeyEvent.VK_RIGHT:
				demoDX = 1;
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				demoDY = 0;
				break;
			case KeyEvent.VK_DOWN:
				demoDY = 0;
				break;
			case KeyEvent.VK_LEFT:
				demoDX = 0;
				break;
			case KeyEvent.VK_RIGHT:
				demoDX = 0;
				break;
			default:
				break;
		}
	}
}
