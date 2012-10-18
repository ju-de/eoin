package java.core;

import dmcigd.core.Game;
import java.applet.*;
import java.awt.*;
import java.util.ArrayList;

public class BufferedDisplay extends Game implements Runnable {
	private ArrayList visibleObjects = new ArrayList();
	private Image dbImage;
	private Graphics dbg;

	//Calls game loop
	public synchronized void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		//Repaint the screen at up to 50fps
		while(true) {
			//Only update the screen if in a state of update (i.e. dialogue, menus, or gameplay)
			if(getCurrentGameState() == GameState.DIALOGUE || getCurrentGameState() == GameState.MENU || getCurrentGameState() == GameState.ACTIVE || getCurrentGameState() == GameState.DEMO) {
				repaint();
			}
      
			//Add delay to thread update - gives breathing room for game loop
			try {
				wait();
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
		//Do not clear screen in case of dialogue - Paused game should remain as background during cutscenes or dialogue)
		if(getCurrentGameState() != GameState.DIALOGUE) {
		  //Clear screen and draw Background
			dbg.setColor(getBackground());
			dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		}
		//Paint the frame to offscreen image
		dbg.setColor (getForeground()); //Debugging code (for drawing shapes such as background colours). Will later be used to render fonts.
		paint (dbg);
		//Draw offscreen image
		g.drawImage (dbImage, 0, 0, this);
	}

	//Calls paint methods of appropriate object
	public void paint(Graphics g) {
		//Check for which paint method to call
		switch(getCurrentGameState()) {
			case PAUSED:
				break;
			case DIALOGUE:
				break;
			case MENU:
				break;
			case ACTIVE:
				break;
			default:
				//Loop through visible objects for X axis
				visibleObjects = demo.getVisibleObjects();
				g.setColor(Color.red);
				for(int i = 0; i < visibleObjects.size(); i++) {
					Integer x = (Integer) visibleObjects.get(i);
					g.fillOval(x,25,25,25);
				}
		}
		//Syncronize Paint with Run - Ensures there is only one paint per loop iteration
		synchronized(this) {
			notifyAll();
		}
	}
}
