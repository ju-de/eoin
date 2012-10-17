package dmcigd;

import java.awt.*;
import java.util.ArrayList;

public class Demo implements Runnable {
	
	private int x;
	private int speed;
	
	private boolean ready = false;
	
	private String map;
	
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();
	
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
		
		map = new String();
		
		map	= "xxxxxxxxxxxxxxxxxxxxxxxxx\n"
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
		
		System.out.println(map);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {}
		
		ready = true;
	}
}
