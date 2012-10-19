package dmcigd;

import dmcigd.core.*;
import dmcigd.core.objects.player.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

import javax.imageio.ImageIO;

public class Demo implements Runnable {
	
	private boolean ready = false;
	public Player player;
	public BlockLoader blockLoader = new BlockLoader();
	
	//Temporary measure to be abstracted later:
	public Map<String, Image> blockImageMap = new HashMap<String, Image>();
	
	public boolean isReady() {
		return ready;
	}
	
	public Demo() {
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
		//Temporary measure to be abstracted later:
		try {
			blockImageMap.put("q", ImageIO.read(new File("../share/gfx/blocks/demo/normal/tl.gif")));
			blockImageMap.put("w", ImageIO.read(new File("../share/gfx/blocks/demo/normal/t1.gif")));
			blockImageMap.put("W", ImageIO.read(new File("../share/gfx/blocks/demo/normal/t2.gif")));
			blockImageMap.put("e", ImageIO.read(new File("../share/gfx/blocks/demo/normal/tr.gif")));
			blockImageMap.put("a", ImageIO.read(new File("../share/gfx/blocks/demo/normal/l1.gif")));
			blockImageMap.put("A", ImageIO.read(new File("../share/gfx/blocks/demo/normal/l2.gif")));
			blockImageMap.put("d", ImageIO.read(new File("../share/gfx/blocks/demo/normal/r1.gif")));
			blockImageMap.put("D", ImageIO.read(new File("../share/gfx/blocks/demo/normal/r2.gif")));
			blockImageMap.put("z", ImageIO.read(new File("../share/gfx/blocks/demo/normal/bl.gif")));
			blockImageMap.put("x", ImageIO.read(new File("../share/gfx/blocks/demo/normal/b1.gif")));
			blockImageMap.put("X", ImageIO.read(new File("../share/gfx/blocks/demo/normal/b2.gif")));
			blockImageMap.put("c", ImageIO.read(new File("../share/gfx/blocks/demo/normal/br.gif")));
			blockImageMap.put("r", ImageIO.read(new File("../share/gfx/blocks/demo/normal/lcap.gif")));
			blockImageMap.put("t", ImageIO.read(new File("../share/gfx/blocks/demo/normal/row1.gif")));
			blockImageMap.put("T", ImageIO.read(new File("../share/gfx/blocks/demo/normal/row2.gif")));
			blockImageMap.put("y", ImageIO.read(new File("../share/gfx/blocks/demo/normal/rcap.gif")));
			blockImageMap.put("f", ImageIO.read(new File("../share/gfx/blocks/demo/normal/tcap.gif")));
			blockImageMap.put("g", ImageIO.read(new File("../share/gfx/blocks/demo/normal/col1.gif")));
			blockImageMap.put("G", ImageIO.read(new File("../share/gfx/blocks/demo/normal/col2.gif")));
			blockImageMap.put("h", ImageIO.read(new File("../share/gfx/blocks/demo/normal/bcap.gif")));
			blockImageMap.put("s", ImageIO.read(new File("../share/gfx/blocks/demo/normal/single.gif")));
			blockImageMap.put(".", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c1.gif")));
			blockImageMap.put(",", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c2.gif")));
			blockImageMap.put("-", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c3.gif")));
			blockImageMap.put("=", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c4.gif")));
		} catch (IOException e) {}
		
	}
	
	public void step() {
		
		player.step();
		
	}
	
	public void run() {
		
		blockLoader.loadBlockMap("demo");
		player = new Player(blockLoader.getSpawnX() * 32, blockLoader.getSpawnY() * 32, blockLoader);
		
		ready = true;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				//Just testing acceleration. Replace this command later
				player.setAX(0.2f);
				break;
			case KeyEvent.VK_DOWN:
				//Just testing acceleration. Remove this command later
				player.setAX(-0.2f);
				break;
			case KeyEvent.VK_LEFT:
				player.setVX(-3);
				break;
			case KeyEvent.VK_RIGHT:
				player.setVX(3);
				break;
			case KeyEvent.VK_Z:
				player.setVY(-3);
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.setAX(0);
				player.setVX(0);
				break;
			case KeyEvent.VK_DOWN:
				player.setAX(0);
				player.setVX(0);
				break;
			case KeyEvent.VK_LEFT:
				player.setVX(0);
				break;
			case KeyEvent.VK_RIGHT:
				player.setVX(0);
				break;
			case KeyEvent.VK_Z:
				player.setVY(2);
				break;
			default:
				break;
		}
	}
}
