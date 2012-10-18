package dmcigd.core;

import java.awt.*;
import java.util.ArrayList;

public class Demo {
	private int x;
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();

	public ArrayList getVisibleObjects() {
		return visibleObjects;
	}

	public Demo() {
		x = 1;
		visibleObjects.add((int) 1);
	}

	public void step() {
		x++;
		visibleObjects.set(0, (int) x);
	}
}
