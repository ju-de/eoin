package dmcigd;

import dmcigd.core.GameState;
import java.applet.*;
import java.awt.*;

//Renders applet
public class DmciGD extends Applet implements Runnable {
	
	//Initializes and synchronizes Main thread (which handles game loops)
	private ThreadSync threadSync = new ThreadSync();
	Main main = new Main(threadSync);
	
	//Initializing gameState variable - decides which screen to paint
	GameState gameState = main.getGameState();
	
	//Initialize visible objects list
	private char[][] visibleBlocks = new char[12][22];
	
	//Initialize the Double-buffering Variables
	private Image dbImage;
	private Graphics dbg;
	
	//Initialize all objects and gets audio data
	public void init() {
		
		//Set canvas background
		setBackground (Color.black);
		
		//Add listener to main thread
		addKeyListener(main);
		
		//Initialize Double-Buffers
		dbImage = createImage(this.getSize().width, this.getSize().height);
		dbg = dbImage.getGraphics();
		
		//Start new thread when applet loads
		Thread th = new Thread(this);
		th.start();
	}
	
	//Repaints screen
	public synchronized void run(){
		
		while (true) {
			
			switch (main.getGameState()) {
				case DEMO:
					
					//Retrieve necessary objects
					gameState = GameState.DEMO;
					visibleBlocks = main.demo.blockLoader.getVisibleBlocks();
					
					threadSync.consume();
					
					//Repaint
					repaint();
					
					//Only repaint after the previous frame has been painted and game is in a state of update - Reduces unnecessary calls
					try {
						wait();
					} catch (InterruptedException ex) {}
					break;
					
				default:
					
					//If not in a state of update, synchronize gameState
					if(gameState != main.getGameState()) {
						
						gameState = main.getGameState();
						
						threadSync.consume();
						
						//Update screen once
						repaint();
						
						//Wait and check again
						try {
							wait();
						} catch (InterruptedException ex) {}
					} else {
						
						threadSync.consume();
						
						//If not in a state of update, wait and keep checking gameState
						try {
							Thread.sleep(50);
						} catch (InterruptedException ex) {}
					}
					break;
			}
			
         
		}
		
	}
	
	//Implements Double-Buffering
	public void update(Graphics g) {
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
				
				//Debugging element. Remove when block collision checks are done
				dbg.setColor(Color.green);
				dbg.fillRect(((main.demo.player.getX()/32)*32) - (main.demo.player.getX()) + 304,((main.demo.player.getY()/32)*32) - (main.demo.player.getY()) +144,32,32);

				dbg.setColor(Color.red);
				
				
				//Loop through Y axis of visibleBlocks
				for(int i=0; i<12; i++) {
					
					//Loop through X axis of visibleBlocks
					for(int j=0; j<22; j++) {
						
						//Draw if object exists
						if(visibleBlocks[i][j] == 'x') {
							dbg.fillRect(j*32 - (main.demo.player.getX() % 32) - 16, i*32 - (main.demo.player.getY() % 32) - 16, 32, 32);
						}
						
					}
					
				}
				
				dbg.fillOval(304, 144, 32, 32);
				
				
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
		
		//Syncronize Paint with Run - Ensures there is only one paint per repaint
		synchronized(this) {
			notifyAll();
		}
		
	}
}
