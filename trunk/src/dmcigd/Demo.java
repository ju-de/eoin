package dmcigd;

import java.awt.*;

public class Demo implements Runnable {
	
	private int x;
	
	public int getX() {
		return x;
	}
	
	public Demo() {
		Thread th = new Thread(this);
		th.start();
	}
	
	public void start () {
		x = 1;
	}
	public void run() {
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while(true) {
			
			x++;

			//Add delay to thread update - gives breathing room for game loop
			try {
				Thread.sleep(5);
			} catch (InterruptedException ex) {}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
		
	}
}
