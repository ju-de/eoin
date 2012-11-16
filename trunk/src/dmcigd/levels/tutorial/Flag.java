package dmcigd.levels.tutorial;

import dmcigd.core.objects.VisibleObject;

public class Flag extends VisibleObject {
	
	public Flag(int x, int y, int type) {
		setX(x);
		setY(y);
		setHeight(72);
		setWidth(32);
		setImageHeight(72);
		setImageWidth(32);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/tutorial/flags.gif");
	}
	
}
