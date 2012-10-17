package dmcigd;

import dmcigd.core.GameState;
import dmcigd.core.interfaces.*;
import java.applet.*;
import java.awt.*;
import java.util.ArrayList;

//Renders applet
public class DmciGD extends Applet implements Runnable {
	
	//Initializes Main Thread
	Main main = new Main();
	
	//Initializing gameState variable - decides which screen to paint
	GameState gameState;
	
	//Initialize visible objects list
	private Block[][] visibleBlocks = new Block[11][20];
	
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
				
				gameState = main.getGameState();
				repaint();
      
				//Only repaint after the previous frame has been painted - Reduces unnecessary calls
				try {
					wait();
				} catch (InterruptedException ex) {}
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				
			} else if(gameState == GameState.DEMO || gameState == GameState.LEVEL || gameState == GameState.DIALOGUE || gameState == GameState.MENU) {
				
				repaint();
      
				//Only repaint after the previous frame has been painted and game is in a state of update - Reduces unnecessary calls
				try {
					wait();
				} catch (InterruptedException ex) {}
				
			} else {
				
				//Wait and check again
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {}
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			}
         
		}
		
	}
	
	//Implements Double-Buffering
	public void update(Graphics g) {

		if(dbg == null) {
			//Initialize Double-Buffers
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		
		paint(g);
	}
	
	//Calls paint methods of appropriate object
	public void paint(Graphics g) {
      
		//Do not clear screen in case of dialogue - Paused game should remain as background during cutscenes or dialogue)
		if(gameState != GameState.DIALOGUE) {

		  //Clear screen and draw Background
		  dbg.setColor(getBackground());
		  dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		}
		
		//Check for which paint method to call
		switch(gameState) {
			case DEMO:

				dbg.setColor(Color.red);
				
				//Retrieve visibleBlocks
				visibleBlocks = main.demo.getVisibleBlocks();
				
				//Loop through Y axis of visibleBlocks
				for(int i=0; i<11; i++) {
					
					//Loop through X axis of visibleBlocks
					for(int j=0; j<21; j++) {
						
						//Draw if object exists
						if(visibleBlocks[i][j] != null) {
							dbg.fillRect(j*32 - (main.demo.getDemoX() % 32), i*32 - (main.demo.getDemoY() % 32), 32, 32);
						}
						
					}
					
				}
				
				break;
				
			case LOADINGDEMO:
				
				dbg.setColor(Color.red);
				dbg.drawString("Loading Demo Level", 40, 75);
				
				break;
				
			case LEVEL:
				break;
				
			case DIALOGUE:
				break;
				
			case MENU:
				break;
				
			case LOADINGLEVEL:
				break;
				
			case LOADING:
				break;
				
			case PAUSE:
				break;
				
			case GAMEOVER:
				break;
				
			default:
				break;
		}
		
		//Draw offscreen image
		g.drawImage (dbImage, 0, 0, this);
		
		//Syncronize Paint with Run - Ensures there is only one paint per loop iteration
		synchronized(this) {
			notifyAll();
		}
		
	}
}
