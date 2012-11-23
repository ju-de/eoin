package dmcigd.levels.rabbit.houses;

import dmcigd.core.objects.VisibleObject;

public class HouseSix extends VisibleObject {

	public HouseSix(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(160);
		setWidth(160);
		setImageHeight(160);
		setImageWidth(160);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/house6.gif");
	}
	
}
