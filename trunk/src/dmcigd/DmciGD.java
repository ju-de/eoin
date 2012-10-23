package dmcigd;

import dmcigd.core.*;
import dmcigd.core.enums.*;

import java.applet.*;
import java.awt.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;

//Renders applet
public class DmciGD extends Applet implements Runnable {
	
	private URL codeBase;
	
	//Initializes and synchronizes Main thread (which handles game loops)
	private ThreadSync threadSync = new ThreadSync();
	private Main main;
	
	//Initializing gameState variable - decides which screen to paint
	GameState gameState;
	
	//Initialize visible objects list
	private Image playerImage;
	private char[][] visibleBlocks = new char[12][22];
	private Map<String, Image> blockImageMap = new HashMap<String, Image>();
	private int playerX;
	private int playerY;
	private int playerSequence;
	private int playerFrame;
	
	//Initialize the Double-buffering Variables
	private Image dbImage;
	private Graphics dbg;
	
	//Initialize all objects and gets audio data
	public void init() {
		codeBase = getCodeBase();
		main = new Main(threadSync, codeBase);
		gameState = main.getGameState();
		
		playerImage = getImageFromPath("player.gif");
		
		//Set canvas background
		setBackground (new Color(200,240,255));
		
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
			
			//Tells Main thread to wait until finished grabbing variables
			//Listens for when new frame is fetched
			threadSync.consume();
			
			switch (main.getGameState()) {
				case DEMO:
					
					if(gameState != GameState.DEMO) {
						
						//Retrieve blockmap
						getBlockImages(main.demo.tileSet);
						
						//ADD A PRELOADING SCRIPT HERE
						//FOR LOADING TILEMAPS
					}
					
					//Retrieve necessary objects
					gameState = GameState.DEMO;
					
					playerX = main.demo.player.getX();
					playerY = main.demo.player.getY();
					
					visibleBlocks = main.demo.blockMap.getVisibleBlocks(playerX, playerY);
					
					playerSequence = main.demo.player.getSequence();
					playerFrame = main.demo.player.getFrame();
					
					//Tells Main thread to begin fetching next frame
					threadSync.consumed();
					
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
						
						//Tells Main thread to begin fetching next frame
						threadSync.consumed();
						
						//Update screen once
						repaint();
						
						//Wait and check again
						try {
							wait();
						} catch (InterruptedException ex) {}
					} else {
						
						//Tells Main thread to begin fetching next frame
						threadSync.consumed();
						
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
				
				//Debugging element: highlights tile associated with player
				//dbg.setColor(Color.green);
				//dbg.fillRect(((main.demo.player.getX()/32)*32) - (main.demo.player.getX()) + 304,((main.demo.player.getY()/32)*32) - (main.demo.player.getY()) +144,32,32);

				dbg.setColor(Color.red);
				
				Image tile;
				
				//Loop through Y axis of visibleBlocks
				for(int i=0; i<12; i++) {
					
					//Loop through X axis of visibleBlocks
					for(int j=0; j<22; j++) {
						
						//Draw if object exists
						if((tile = blockImageMap.get(String.valueOf(visibleBlocks[i][j]))) != null) {
							dbg.drawImage(tile, j*32 - (playerX % 32) - 10, i*32 - (playerY % 32) - 16, j*32 - (playerX % 32) + 22, i*32 - (playerY % 32) + 16, 0, 0, 16, 16, this);
						}
						
					}
					
				}

				dbg.drawImage(playerImage, 308, 144, 332, 176, playerFrame * 12, playerSequence * 16, playerFrame * 12 + 12, playerSequence * 16 + 16, this);
				
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
	
	//Image Loading Script
	public Image getImageFromPath(String path) {
		
		//Retrieve image
		Image image = getImage(getCodeBase(), "../share/gfx/"+path);
		
		//Wait for image to load
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(image, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) { }
		
		return image;
	}
	
	public void getBlockImages(String folder) {
		blockImageMap.put("q", getImageFromPath(folder+"/normal/blocks/tl.gif"));
		blockImageMap.put("w", getImageFromPath(folder+"/normal/blocks/t1.gif"));
		blockImageMap.put("W", getImageFromPath(folder+"/normal/blocks/t2.gif"));
		blockImageMap.put("e", getImageFromPath(folder+"/normal/blocks/tr.gif"));
		blockImageMap.put("a", getImageFromPath(folder+"/normal/blocks/l1.gif"));
		blockImageMap.put("A", getImageFromPath(folder+"/normal/blocks/l2.gif"));
		blockImageMap.put("d", getImageFromPath(folder+"/normal/blocks/r1.gif"));
		blockImageMap.put("D", getImageFromPath(folder+"/normal/blocks/r2.gif"));
		blockImageMap.put("z", getImageFromPath(folder+"/normal/blocks/bl.gif"));
		blockImageMap.put("x", getImageFromPath(folder+"/normal/blocks/b1.gif"));
		blockImageMap.put("X", getImageFromPath(folder+"/normal/blocks/b2.gif"));
		blockImageMap.put("c", getImageFromPath(folder+"/normal/blocks/br.gif"));
		blockImageMap.put("t", getImageFromPath(folder+"/normal/blocks/lcap.gif"));
		blockImageMap.put("y", getImageFromPath(folder+"/normal/blocks/row1.gif"));
		blockImageMap.put("Y", getImageFromPath(folder+"/normal/blocks/row2.gif"));
		blockImageMap.put("u", getImageFromPath(folder+"/normal/blocks/rcap.gif"));
		blockImageMap.put("r", getImageFromPath(folder+"/normal/blocks/tcap.gif"));
		blockImageMap.put("f", getImageFromPath(folder+"/normal/blocks/col1.gif"));
		blockImageMap.put("F", getImageFromPath(folder+"/normal/blocks/col2.gif"));
		blockImageMap.put("v", getImageFromPath(folder+"/normal/blocks/bcap.gif"));
		blockImageMap.put("s", getImageFromPath(folder+"/normal/blocks/single.gif"));
		blockImageMap.put(".", getImageFromPath(folder+"/normal/blocks/c1.gif"));
		blockImageMap.put(",", getImageFromPath(folder+"/normal/blocks/c2.gif"));
		blockImageMap.put("-", getImageFromPath(folder+"/normal/blocks/c3.gif"));
		blockImageMap.put("=", getImageFromPath(folder+"/normal/blocks/c4.gif"));
		
		blockImageMap.put("i", getImageFromPath(folder+"/normal/blocks/platform/lcap.gif"));
		blockImageMap.put("o", getImageFromPath(folder+"/normal/blocks/platform/row.gif"));
		blockImageMap.put("p", getImageFromPath(folder+"/normal/blocks/platform/rcap.gif"));
		blockImageMap.put("O", getImageFromPath(folder+"/normal/blocks/platform/single.gif"));
		blockImageMap.put("_", getImageFromPath(folder+"/normal/blocks/platform/moving.gif"));
		
		blockImageMap.put("g", getImageFromPath(folder+"/normal/blocks/ladder/lcap.gif"));
		blockImageMap.put("h", getImageFromPath(folder+"/normal/blocks/ladder/row.gif"));
		blockImageMap.put("j", getImageFromPath(folder+"/normal/blocks/ladder/rcap.gif"));
		blockImageMap.put("G", getImageFromPath(folder+"/normal/blocks/ladder/tl.gif"));
		blockImageMap.put("H", getImageFromPath(folder+"/normal/blocks/ladder/t.gif"));
		blockImageMap.put("J", getImageFromPath(folder+"/normal/blocks/ladder/tr.gif"));
		blockImageMap.put("b", getImageFromPath(folder+"/normal/blocks/ladder/l.gif"));
		blockImageMap.put("n", getImageFromPath(folder+"/normal/blocks/ladder/c.gif"));
		blockImageMap.put("m", getImageFromPath(folder+"/normal/blocks/ladder/r.gif"));
		blockImageMap.put("B", getImageFromPath(folder+"/normal/blocks/ladder/bl.gif"));
		blockImageMap.put("N", getImageFromPath(folder+"/normal/blocks/ladder/b.gif"));
		blockImageMap.put("M", getImageFromPath(folder+"/normal/blocks/ladder/br.gif"));
		blockImageMap.put("k", getImageFromPath(folder+"/normal/blocks/ladder/single.gif"));
		blockImageMap.put("l", getImageFromPath(folder+"/normal/blocks/ladder/air.gif"));
		blockImageMap.put("L", getImageFromPath(folder+"/normal/blocks/ladder/end.gif"));
		
		blockImageMap.put("^", getImageFromPath(folder+"/normal/blocks/spikes/up.gif"));
		blockImageMap.put("V", getImageFromPath(folder+"/normal/blocks/spikes/down.gif"));
		blockImageMap.put(">", getImageFromPath(folder+"/normal/blocks/spikes/right.gif"));
		blockImageMap.put("<", getImageFromPath(folder+"/normal/blocks/spikes/left.gif"));
	}
}
