package dmcigd.levels.rabbit.houses;

import dmcigd.core.objects.VisibleObject;

public class HouseThree extends VisibleObject {

	public HouseThree(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(160);
		setWidth(180);
		setImageHeight(160);
		setImageWidth(180);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/house3.gif");
	}
	
}
