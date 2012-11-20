package dmcigd.levels.rabbit;

import dmcigd.core.objects.VisibleObject;

public class HouseFour extends VisibleObject {

	public HouseFour(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(96);
		setWidth(64);
		setImageHeight(96);
		setImageWidth(64);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/house4.gif");
	}
	
}
