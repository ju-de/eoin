package dmcigd.levels.faerie;

import dmcigd.core.objects.VisibleObject;

public class Decoration extends VisibleObject {

	public Decoration(int x, int y, int type, int width, int height, String fileName) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setImageWidth(width);
		setImageHeight(height);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/faerie/"+fileName);
	}
}
