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
		
		//Set gameState variable (currently at 2 for Demo Screen, should be changed to 0 for real game)
		gameState = 3;
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
      
      //Only update the screen if in a state of update (i.e. dialogue, menus, or gameplay)
      if(gameState >= 0) {
        repaint();
      }
      
      //Add delay to thread update - gives breathing room for game loop
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
      
    //Do not clear screen in case of dialogue - Paused game should remain as background during cutscenes or dialogue)
    if(gameState == 0) {
    
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
		if(gameState == -1) {
      //Paused Game
      
		} else if (gameState == 0) {
      //Dialogue boxes and Cutscenes
      
		} else if (gameState == 1) {
			//Start Menu
      
		} else if (gameState == 2) {
			//Gameplay Screen
      
		} else if (gameState == 3) {
			//Demo or Debugging state - Remove from final game
      
		}
		
	}
}
