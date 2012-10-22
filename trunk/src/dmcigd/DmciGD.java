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
		
		playerImage = getImageFromPath("blocks/demo/playertemp.gif");
		
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
		return getImage(getCodeBase(), "../share/gfx/"+path);
	}
	
	public void getBlockImages(String folder) {
		blockImageMap.put("q", getImageFromPath("blocks/"+folder+"/normal/tl.gif"));
		blockImageMap.put("w", getImageFromPath("blocks/"+folder+"/normal/t1.gif"));
		blockImageMap.put("W", getImageFromPath("blocks/"+folder+"/normal/t2.gif"));
		blockImageMap.put("e", getImageFromPath("blocks/"+folder+"/normal/tr.gif"));
		blockImageMap.put("a", getImageFromPath("blocks/"+folder+"/normal/l1.gif"));
		blockImageMap.put("A", getImageFromPath("blocks/"+folder+"/normal/l2.gif"));
		blockImageMap.put("d", getImageFromPath("blocks/"+folder+"/normal/r1.gif"));
		blockImageMap.put("D", getImageFromPath("blocks/"+folder+"/normal/r2.gif"));
		blockImageMap.put("z", getImageFromPath("blocks/"+folder+"/normal/bl.gif"));
		blockImageMap.put("x", getImageFromPath("blocks/"+folder+"/normal/b1.gif"));
		blockImageMap.put("X", getImageFromPath("blocks/"+folder+"/normal/b2.gif"));
		blockImageMap.put("c", getImageFromPath("blocks/"+folder+"/normal/br.gif"));
		blockImageMap.put("t", getImageFromPath("blocks/"+folder+"/normal/lcap.gif"));
		blockImageMap.put("y", getImageFromPath("blocks/"+folder+"/normal/row1.gif"));
		blockImageMap.put("Y", getImageFromPath("blocks/"+folder+"/normal/row2.gif"));
		blockImageMap.put("u", getImageFromPath("blocks/"+folder+"/normal/rcap.gif"));
		blockImageMap.put("r", getImageFromPath("blocks/"+folder+"/normal/tcap.gif"));
		blockImageMap.put("f", getImageFromPath("blocks/"+folder+"/normal/col1.gif"));
		blockImageMap.put("F", getImageFromPath("blocks/"+folder+"/normal/col2.gif"));
		blockImageMap.put("v", getImageFromPath("blocks/"+folder+"/normal/bcap.gif"));
		blockImageMap.put("s", getImageFromPath("blocks/"+folder+"/normal/single.gif"));
		blockImageMap.put(".", getImageFromPath("blocks/"+folder+"/normal/c1.gif"));
		blockImageMap.put(",", getImageFromPath("blocks/"+folder+"/normal/c2.gif"));
		blockImageMap.put("-", getImageFromPath("blocks/"+folder+"/normal/c3.gif"));
		blockImageMap.put("=", getImageFromPath("blocks/"+folder+"/normal/c4.gif"));
		
		blockImageMap.put("i", getImageFromPath("blocks/"+folder+"/normal/platformlcap.gif"));
		blockImageMap.put("o", getImageFromPath("blocks/"+folder+"/normal/platformrow.gif"));
		blockImageMap.put("p", getImageFromPath("blocks/"+folder+"/normal/platformrcap.gif"));
		blockImageMap.put("O", getImageFromPath("blocks/"+folder+"/normal/platformsingle.gif"));
		blockImageMap.put("_", getImageFromPath("blocks/"+folder+"/normal/platformmoving.gif"));
		
		blockImageMap.put("g", getImageFromPath("blocks/"+folder+"/normal/ladder/lcap.gif"));
		blockImageMap.put("h", getImageFromPath("blocks/"+folder+"/normal/ladder/row.gif"));
		blockImageMap.put("j", getImageFromPath("blocks/"+folder+"/normal/ladder/rcap.gif"));
		blockImageMap.put("G", getImageFromPath("blocks/"+folder+"/normal/ladder/tl.gif"));
		blockImageMap.put("H", getImageFromPath("blocks/"+folder+"/normal/ladder/t.gif"));
		blockImageMap.put("J", getImageFromPath("blocks/"+folder+"/normal/ladder/tr.gif"));
		blockImageMap.put("b", getImageFromPath("blocks/"+folder+"/normal/ladder/l.gif"));
		blockImageMap.put("n", getImageFromPath("blocks/"+folder+"/normal/ladder/c.gif"));
		blockImageMap.put("m", getImageFromPath("blocks/"+folder+"/normal/ladder/r.gif"));
		blockImageMap.put("B", getImageFromPath("blocks/"+folder+"/normal/ladder/bl.gif"));
		blockImageMap.put("N", getImageFromPath("blocks/"+folder+"/normal/ladder/b.gif"));
		blockImageMap.put("M", getImageFromPath("blocks/"+folder+"/normal/ladder/br.gif"));
		blockImageMap.put("k", getImageFromPath("blocks/"+folder+"/normal/ladder/single.gif"));
		blockImageMap.put("l", getImageFromPath("blocks/"+folder+"/normal/ladder/air.gif"));
		blockImageMap.put("L", getImageFromPath("blocks/"+folder+"/normal/ladder/end.gif"));
		
		blockImageMap.put("^", getImageFromPath("blocks/"+folder+"/normal/spikes/up.gif"));
		blockImageMap.put("V", getImageFromPath("blocks/"+folder+"/normal/spikes/down.gif"));
		blockImageMap.put(">", getImageFromPath("blocks/"+folder+"/normal/spikes/right.gif"));
		blockImageMap.put("<", getImageFromPath("blocks/"+folder+"/normal/spikes/left.gif"));
	}
}
