package dmcigd.levels.deer;

import dmcigd.core.objects.VisibleObject;

public class House extends VisibleObject {

	public House(int x, int y, int type, int width, int height, int houseid) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setImageWidth(width);
		setImageHeight(height);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/deer/house"+houseid+".gif");
	}
}
