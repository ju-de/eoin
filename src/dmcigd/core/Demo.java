package dmcigd.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	private int x;
	//Initialize visible objects list
	private ArrayList visibleObjects = new ArrayList();
	
	//Temporary code to be abstracted later
	public Map<String, Image> blockImageMap = new HashMap<String, Image>();

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
