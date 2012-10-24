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
	private char[][] visibleEnvironment = new char[12][22];
	private Image tileSheet;
	private Map<String, int[]> imageMap = new HashMap<String, int[]>();
	private int playerX;
	private int playerY;
	private int playerSequence;
	private int playerFrame;
	private boolean playerFlipped;
	
	//Initialize the Double-buffering Variables
	private Image dbImage;
	private Graphics dbg;
	
	//Initialize all objects and gets audio data
	public void init() {
		codeBase = getCodeBase();
		main = new Main(threadSync, codeBase);
		gameState = main.getGameState();
		
		//Add listener to main thread
		addKeyListener(main);
		
		//Set canvas background
		setBackground (new Color(200,240,255));
		
		playerImage = getImageFromPath("player.gif");
		
		//Preload player spritesheet
		
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(playerImage, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) { }
		
		buildImageMap();
		
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
						
						tileSheet = getImageFromPath(main.demo.tileSet+"/tilesheet.gif");
						
						//Preload map tilesheet
						MediaTracker mt = new MediaTracker(this);
						mt.addImage(tileSheet, 0);
						try {
							mt.waitForAll();
						} catch (InterruptedException e) { }
					}
					
					//Retrieve necessary objects
					gameState = GameState.DEMO;
					
					playerX = main.demo.player.getX();
					playerY = main.demo.player.getY();
					
					visibleBlocks = main.demo.blockMap.getVisibleBlocks(playerX, playerY);
					visibleEnvironment = main.demo.environmentMap.getVisibleEnvironment(playerX, playerY);
					
					playerSequence = main.demo.player.getSequence();
					playerFrame = main.demo.player.getFrame();
					
					playerFlipped = main.demo.player.flipped;
					
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
				
				int[] tileLocation;
				
				//Draw blocks
				
				//Loop through Y axis of visibleBlocks
				for(int i=0; i<12; i++) {
					//Loop through X axis of visibleBlocks
					for(int j=0; j<22; j++) {
						
						//Draw Environment
						if((tileLocation = imageMap.get("e_"+String.valueOf(visibleEnvironment[i][j]))) != null) {
							dbg.drawImage(tileSheet, j*32 - (playerX % 32) - 10, i*32 - (playerY % 32) - 16, j*32 - (playerX % 32) + 22, i*32 - (playerY % 32) + 16, tileLocation[0] * 16, tileLocation[1] * 16, tileLocation[0] * 16 + 16, tileLocation[1] * 16 + 16, this);
						}
						//Draw Block
						if((tileLocation = imageMap.get(String.valueOf(visibleBlocks[i][j]))) != null) {
							dbg.drawImage(tileSheet, j*32 - (playerX % 32) - 10, i*32 - (playerY % 32) - 16, j*32 - (playerX % 32) + 22, i*32 - (playerY % 32) + 16, tileLocation[0] * 16, tileLocation[1] * 16, tileLocation[0] * 16 + 16, tileLocation[1] * 16 + 16, this);
						}
					}
				}
				
				int x1, x2;
				
				if(playerFlipped) {
					x1 = 332;
					x2 = 308;
				} else {
					x1 = 308;
					x2 = 332;
				}
				
				dbg.drawImage(playerImage, x1, 144, x2, 176, playerFrame * 12, playerSequence * 16, playerFrame * 12 + 12, playerSequence * 16 + 16, this);
				
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
		
		return image;
	}
	
	public void buildImageMap() {
		
		//BLOCKS
		imageMap.put("q", new int[] {1, 1});
		imageMap.put("w", new int[] {2, 1});
		imageMap.put("W", new int[] {3, 1});
		imageMap.put("e", new int[] {4, 1});
		imageMap.put("a", new int[] {1, 2});
		imageMap.put(".", new int[] {2, 2});
		imageMap.put(",", new int[] {3, 2});
		imageMap.put("d", new int[] {4, 2});
		imageMap.put("A", new int[] {1, 3});
		imageMap.put("-", new int[] {2, 3});
		imageMap.put("=", new int[] {3, 3});
		imageMap.put("D", new int[] {4, 3});
		imageMap.put("z", new int[] {1, 4});
		imageMap.put("x", new int[] {2, 4});
		imageMap.put("X", new int[] {3, 4});
		imageMap.put("c", new int[] {4, 4});
		
		imageMap.put("t", new int[] {1, 0});
		imageMap.put("y", new int[] {2, 0});
		imageMap.put("Y", new int[] {3, 0});
		imageMap.put("u", new int[] {4, 0});
		
		imageMap.put("r", new int[] {0, 1});
		imageMap.put("f", new int[] {0, 2});
		imageMap.put("F", new int[] {0, 3});
		imageMap.put("v", new int[] {0, 4});
		
		imageMap.put("s", new int[] {0, 0});
		
		//Platforms

		imageMap.put("O", new int[] {5, 4});
		imageMap.put("i", new int[] {6, 4});
		imageMap.put("o", new int[] {7, 4});
		imageMap.put("p", new int[] {8, 4});
		imageMap.put("_", new int[] {5, 3});
		
		//Ladders
		imageMap.put("k", new int[] {5, 0});
		imageMap.put("l", new int[] {5, 1});
		imageMap.put("L", new int[] {5, 2});
		
		imageMap.put("g", new int[] {6, 0});
		imageMap.put("h", new int[] {7, 0});
		imageMap.put("j", new int[] {8, 0});
		
		imageMap.put("G", new int[] {6, 1});
		imageMap.put("H", new int[] {7, 1});
		imageMap.put("J", new int[] {8, 1});
		imageMap.put("b", new int[] {6, 2});
		imageMap.put("n", new int[] {7, 2});
		imageMap.put("m", new int[] {8, 2});
		imageMap.put("B", new int[] {6, 3});
		imageMap.put("N", new int[] {7, 3});
		imageMap.put("M", new int[] {8, 3});
		
		//Spikes
		
		imageMap.put("^", new int[] {9, 0});
		imageMap.put("V", new int[] {9, 1});
		imageMap.put(">", new int[] {9, 2});
		imageMap.put("<", new int[] {9, 3});
		
		//ENVIRONMENT
		//Ground
		imageMap.put("e_q", new int[] {10, 0});
		imageMap.put("e_w", new int[] {11, 0});
		imageMap.put("e_e", new int[] {12, 0});
		imageMap.put("e_a", new int[] {10, 1});
		imageMap.put("e_s", new int[] {11, 1});
		imageMap.put("e_d", new int[] {12, 1});
		imageMap.put("e_z", new int[] {10, 2});
		imageMap.put("e_x", new int[] {11, 2});
		imageMap.put("e_c", new int[] {12, 2});
		
		//Water
		imageMap.put("e_r", new int[] {13, 0});
		imageMap.put("e_t", new int[] {14, 0});
		imageMap.put("e_y", new int[] {15, 0});
		imageMap.put("e_f", new int[] {13, 1});
		imageMap.put("e_g", new int[] {14, 1});
		imageMap.put("e_h", new int[] {15, 1});
		imageMap.put("e_v", new int[] {13, 2});
		imageMap.put("e_b", new int[] {14, 2});
		imageMap.put("e_n", new int[] {15, 2});
		
		//Underground Environment
		imageMap.put("e_J", new int[] {10, 4});
		imageMap.put("e_K", new int[] {11, 4});
		imageMap.put("e_L", new int[] {12, 4});
		
		//Overworld Environment
		imageMap.put("e_u", new int[] {13, 3});
		imageMap.put("e_i", new int[] {14, 3});
		imageMap.put("e_o", new int[] {15, 3});
		imageMap.put("e_j", new int[] {13, 4});
		imageMap.put("e_k", new int[] {14, 4});
		imageMap.put("e_l", new int[] {15, 4});
	}
}
