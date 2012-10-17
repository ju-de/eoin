package dmcigd;

import java.awt.*;
import java.util.ArrayList;

public class Demo {
	
	private int x;
	private int speed;
	
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();
	
	public ArrayList getVisibleObjects() {
		return visibleObjects;
	}
	
	public Demo() {
		
		x = 1;
		speed = 1;
		visibleObjects.add((int) 1);
		
	}
	
	public void step() {
		
		if(x >= 630) {
			speed = -1;
		}else if(x <= 0) {
			speed = 1;
		}
			
		x = x + speed;
		
		visibleObjects.set(0, (int) x);
		
	}
}
