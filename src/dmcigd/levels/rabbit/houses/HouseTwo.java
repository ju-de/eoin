package dmcigd.levels.rabbit.houses;

import dmcigd.core.objects.VisibleObject;

public class HouseTwo extends VisibleObject {

	public HouseTwo(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(96);
		setWidth(96);
		setImageHeight(96);
		setImageWidth(96);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/house2.gif");
	}
	
}
