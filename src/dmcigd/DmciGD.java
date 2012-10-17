package dmcigd;

import java.applet.*;
import java.awt.*;
import java.util.ArrayList;

//Renders applet
public class DmciGD extends Applet implements Runnable {
	
	//Initializes Main Thread
	Main main = new Main();
	
	//Initializing gameState variable - decides which screen to paint
	int gameState;
	
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();
	
	//Initialize the Double-buffering Variables
	int appletsize_x = 640;
	int appletsize_y = 320;
	private Image dbImage;
	private Graphics dbg;
	
	//Initialize all objects and gets audio data
	public void init() {
		
		//Set canvas background
		setBackground (Color.black);
		
		//Add listener to main thread
		addKeyListener(main);
	}
	
	//Starts thread
	public void start () {
		
		//Start new thread when applet loads
		Thread th = new Thread(this);
		th.start();
		
	}
	
	//Repaints screen
	public synchronized void run(){
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while (true) {
			
			//Only update the screen if it is changing (i.e. change of state, dialogue, menus, or gameplay)
			if(gameState != main.getGameState()) {
				repaint();
				gameState = main.getGameState();
			} else if(gameState >= 0) {
				repaint();
			}
      
			//Only repaint after the previous frame has been painted - Reduces unnecessary calls
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
		if(gameState != 0) {

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
			
			//Loop through visible objects for X axis
			
			visibleObjects = main.demo.getVisibleObjects();
			
			g.setColor(Color.red);
			for(int i = 0; i < visibleObjects.size(); i++) {
				int x = (int) visibleObjects.get(i);
				g.fillOval(x,10,10,10);
			}
		}
		
		//Syncronize Paint with Run - Ensures there is only one paint per loop iteration
		synchronized(this) {
			notifyAll();
		}
		
	}
}
