package dmcigd.levels.rabbit;

import dmcigd.core.objects.VisibleObject;

public class Flag extends VisibleObject {
	
	public Flag(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(96);
		setWidth(32);
		setImageHeight(96);
		setImageWidth(32);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/rabbit/flags.gif");
	}
}
