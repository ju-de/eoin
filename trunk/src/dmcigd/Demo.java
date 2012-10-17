package dmcigd;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Demo implements Runnable {
	
	private int x;
	private int speed;
	
	private boolean ready = false;
	
	//Initialize mapping variables
	private String mapRaw;
	private String[] map;
	private int spawnX;
	private int spawnY;
	
	//Initialize object lists
	private ArrayList visibleObjects = new ArrayList();
	private ArrayList visibleBlocks;
	
	public boolean isReady() {
		return ready;
	}
	
	public ArrayList getVisibleObjects() {
		return visibleObjects;
	}
	
	public Demo() {
		
		x = 1;
		speed = 1;
		visibleObjects.add((int) 1);
		
		//Initializes Thread
		Thread th = new Thread(this);
		th.start();
		
	}
	
	public void step() {
		
		if(x >= 130) {
			speed = -1;
		}else if(x <= 0) {
			speed = 1;
		}
			
		x = x + speed;
		
		visibleObjects.set(0, (int) x);
		
	}
	
	public void run() {
		
		//Load maps
		mapRaw	= "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxx               xxxxx\n"
			+ "xxxxx               xxxxx\n"
			+ "xxxxx               xxxxx\n"
			+ "xxxxx       1       xxxxx\n"
			+ "xxxxx    xxxxxxx    xxxxx\n"
			+ "xxxxx               xxxxx\n"
			+ "xxxxx               xxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
			+ "xxxxxxxxxxxxxxxxxxxxxxxxx";
		
		//Split map into useable array
		map = mapRaw.split("\n");
		
		//Find spawn location
		for(int i = 0; i < map.length; i++) {
			if(map[i].contains("1")) {
				spawnX = map[i].indexOf("1");
				spawnY = i;
			}
		}
		
		System.out.println(map[spawnY].charAt(spawnX));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {}
		
		ready = true;
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
}
