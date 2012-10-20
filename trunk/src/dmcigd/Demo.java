package dmcigd;

import dmcigd.core.*;
import dmcigd.core.objects.*;
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
	public BlockMap blockMap = new BlockMap();
	
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
			blockImageMap.put("t", ImageIO.read(new File("../share/gfx/blocks/demo/normal/lcap.gif")));
			blockImageMap.put("y", ImageIO.read(new File("../share/gfx/blocks/demo/normal/row1.gif")));
			blockImageMap.put("Y", ImageIO.read(new File("../share/gfx/blocks/demo/normal/row2.gif")));
			blockImageMap.put("u", ImageIO.read(new File("../share/gfx/blocks/demo/normal/rcap.gif")));
			blockImageMap.put("r", ImageIO.read(new File("../share/gfx/blocks/demo/normal/tcap.gif")));
			blockImageMap.put("f", ImageIO.read(new File("../share/gfx/blocks/demo/normal/col1.gif")));
			blockImageMap.put("F", ImageIO.read(new File("../share/gfx/blocks/demo/normal/col2.gif")));
			blockImageMap.put("v", ImageIO.read(new File("../share/gfx/blocks/demo/normal/bcap.gif")));
			blockImageMap.put("s", ImageIO.read(new File("../share/gfx/blocks/demo/normal/single.gif")));
			blockImageMap.put(".", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c1.gif")));
			blockImageMap.put(",", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c2.gif")));
			blockImageMap.put("-", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c3.gif")));
			blockImageMap.put("=", ImageIO.read(new File("../share/gfx/blocks/demo/normal/c4.gif")));
			blockImageMap.put("g", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/lcap.gif")));
			blockImageMap.put("h", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/row.gif")));
			blockImageMap.put("j", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/rcap.gif")));
			blockImageMap.put("G", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/tl.gif")));
			blockImageMap.put("H", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/t.gif")));
			blockImageMap.put("J", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/tr.gif")));
			blockImageMap.put("b", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/l.gif")));
			blockImageMap.put("n", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/c.gif")));
			blockImageMap.put("m", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/r.gif")));
			blockImageMap.put("B", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/bl.gif")));
			blockImageMap.put("N", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/b.gif")));
			blockImageMap.put("M", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/br.gif")));
			blockImageMap.put("i", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/single.gif")));
			blockImageMap.put("k", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/air.gif")));
			blockImageMap.put("K", ImageIO.read(new File("../share/gfx/blocks/demo/ladder/end.gif")));
		} catch (IOException e) {}
		
	}
	
	public void step() {
		
		player.step();
		
	}
	
	public void run() {
		
		blockMap.loadBlockMap("demo");
		player = new Player(blockMap.getSpawnX() * 32, blockMap.getSpawnY() * 32, blockMap);
		
		ready = true;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.climbUp(true);
				break;
			case KeyEvent.VK_DOWN:
				player.keyDown(true);
				break;
			case KeyEvent.VK_LEFT:
				player.walk(true, Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				player.walk(true, Direction.RIGHT);
				break;
			case KeyEvent.VK_Z:
				player.jump(true);
				break;
			default:
				break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_UP:
				player.climbUp(false);
				break;
			case KeyEvent.VK_DOWN:
				player.keyDown(false);
				break;
			case KeyEvent.VK_LEFT:
				player.walk(false, Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				player.walk(false, Direction.RIGHT);
				break;
			case KeyEvent.VK_Z:
				player.jump(false);
				break;
			default:
				break;
		}
	}
}
