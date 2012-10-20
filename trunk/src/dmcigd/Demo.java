package dmcigd;

import dmcigd.core.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.player.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Demo implements Runnable {
	
	//Image Loader
	Toolkit tk = Toolkit.getDefaultToolkit();
	
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
		blockImageMap.put("q", tk.getImage("../share/gfx/blocks/demo/normal/tl.gif"));
		blockImageMap.put("w", tk.getImage("../share/gfx/blocks/demo/normal/t1.gif"));
		blockImageMap.put("W", tk.getImage("../share/gfx/blocks/demo/normal/t2.gif"));
		blockImageMap.put("e", tk.getImage("../share/gfx/blocks/demo/normal/tr.gif"));
		blockImageMap.put("a", tk.getImage("../share/gfx/blocks/demo/normal/l1.gif"));
		blockImageMap.put("A", tk.getImage("../share/gfx/blocks/demo/normal/l2.gif"));
		blockImageMap.put("d", tk.getImage("../share/gfx/blocks/demo/normal/r1.gif"));
		blockImageMap.put("D", tk.getImage("../share/gfx/blocks/demo/normal/r2.gif"));
		blockImageMap.put("z", tk.getImage("../share/gfx/blocks/demo/normal/bl.gif"));
		blockImageMap.put("x", tk.getImage("../share/gfx/blocks/demo/normal/b1.gif"));
		blockImageMap.put("X", tk.getImage("../share/gfx/blocks/demo/normal/b2.gif"));
		blockImageMap.put("c", tk.getImage("../share/gfx/blocks/demo/normal/br.gif"));
		blockImageMap.put("t", tk.getImage("../share/gfx/blocks/demo/normal/lcap.gif"));
		blockImageMap.put("y", tk.getImage("../share/gfx/blocks/demo/normal/row1.gif"));
		blockImageMap.put("Y", tk.getImage("../share/gfx/blocks/demo/normal/row2.gif"));
		blockImageMap.put("u", tk.getImage("../share/gfx/blocks/demo/normal/rcap.gif"));
		blockImageMap.put("r", tk.getImage("../share/gfx/blocks/demo/normal/tcap.gif"));
		blockImageMap.put("f", tk.getImage("../share/gfx/blocks/demo/normal/col1.gif"));
		blockImageMap.put("F", tk.getImage("../share/gfx/blocks/demo/normal/col2.gif"));
		blockImageMap.put("v", tk.getImage("../share/gfx/blocks/demo/normal/bcap.gif"));
		blockImageMap.put("s", tk.getImage("../share/gfx/blocks/demo/normal/single.gif"));
		blockImageMap.put(".", tk.getImage("../share/gfx/blocks/demo/normal/c1.gif"));
		blockImageMap.put(",", tk.getImage("../share/gfx/blocks/demo/normal/c2.gif"));
		blockImageMap.put("-", tk.getImage("../share/gfx/blocks/demo/normal/c3.gif"));
		blockImageMap.put("=", tk.getImage("../share/gfx/blocks/demo/normal/c4.gif"));
		blockImageMap.put("i", tk.getImage("../share/gfx/blocks/demo/normal/platformlcap.gif"));
		blockImageMap.put("o", tk.getImage("../share/gfx/blocks/demo/normal/platformrow.gif"));
		blockImageMap.put("p", tk.getImage("../share/gfx/blocks/demo/normal/platformrcap.gif"));
		blockImageMap.put("O", tk.getImage("../share/gfx/blocks/demo/normal/platformsingle.gif"));
		blockImageMap.put("g", tk.getImage("../share/gfx/blocks/demo/normal/ladder/lcap.gif"));
		blockImageMap.put("h", tk.getImage("../share/gfx/blocks/demo/normal/ladder/row.gif"));
		blockImageMap.put("j", tk.getImage("../share/gfx/blocks/demo/normal/ladder/rcap.gif"));
		blockImageMap.put("G", tk.getImage("../share/gfx/blocks/demo/normal/ladder/tl.gif"));
		blockImageMap.put("H", tk.getImage("../share/gfx/blocks/demo/normal/ladder/t.gif"));
		blockImageMap.put("J", tk.getImage("../share/gfx/blocks/demo/normal/ladder/tr.gif"));
		blockImageMap.put("b", tk.getImage("../share/gfx/blocks/demo/normal/ladder/l.gif"));
		blockImageMap.put("n", tk.getImage("../share/gfx/blocks/demo/normal/ladder/c.gif"));
		blockImageMap.put("m", tk.getImage("../share/gfx/blocks/demo/normal/ladder/r.gif"));
		blockImageMap.put("B", tk.getImage("../share/gfx/blocks/demo/normal/ladder/bl.gif"));
		blockImageMap.put("N", tk.getImage("../share/gfx/blocks/demo/normal/ladder/b.gif"));
		blockImageMap.put("M", tk.getImage("../share/gfx/blocks/demo/normal/ladder/br.gif"));
		blockImageMap.put("k", tk.getImage("../share/gfx/blocks/demo/normal/ladder/single.gif"));
		blockImageMap.put("l", tk.getImage("../share/gfx/blocks/demo/normal/ladder/air.gif"));
		blockImageMap.put("L", tk.getImage("../share/gfx/blocks/demo/normal/ladder/end.gif"));
		
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
