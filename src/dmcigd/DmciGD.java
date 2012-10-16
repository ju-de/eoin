package dmcigd;

import java.applet.*;
import java.awt.*;

public class DmciGD extends Applet implements Runnable {
	
	//Initializing gameState variable - decides which screen to paint
	int gameState;
	
	//Declare applet size
	int appletsize_x = 640;
	int appletsize_y = 320;
	
	//Initialize the Double-buffering Variables
	private Image dbImage;
	private Graphics dbg;
	
	//Initialize all objects and gets audio data
	public void init() {
		
		//Set canvas background
		setBackground (Color.black);
		
		//Set gameState variable (currently at -1 for Demo Screen, should be changed to 0 for real game)
		gameState = -1;
	}
	
	//Starts thread
	public void start () {
		
		//Start new thread when applet loads
		Thread th = new Thread(this);
		th.start();
		
	}
	
	//Stops thread
	public void stop () {
		
	}
	
	//Calls game loop
	public void run(){
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		//Repaint the screen at up to 50fps
		while (true) {
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
		
	}
	
	//Implements Double-Buffering
	public void update(Graphics g) {
		
		//Initialize Double-Buffering
		if(dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}	
		
		//Clear screen and draw Background
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		dbg.setColor (getForeground());
		paint (dbg);
		
		//Draw offscreen image
		g.drawImage (dbImage, 0, 0, this);
		
	}
	
	//Calls paint methods of appropriate object
	public void paint(Graphics g) {
		
		//Check for which paint method to call
		if(gameState == -1) {
			//Demo Level
		} else if (gameState == 0) {
			//Start Screen
		} else if (gameState == 1) {
			//Gameplay Screen
		}
		
	}
}
