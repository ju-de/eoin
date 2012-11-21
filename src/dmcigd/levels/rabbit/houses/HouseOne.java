package dmcigd.levels.rabbit.houses;

import dmcigd.core.objects.VisibleObject;

public class HouseOne extends VisibleObject {

	public HouseOne(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(160);
		setWidth(200);
		setImageHeight(160);
		setImageWidth(200);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/house1.gif");
	}
	
}
