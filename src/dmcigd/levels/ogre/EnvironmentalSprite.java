package dmcigd.levels.ogre;

import dmcigd.core.objects.VisibleObject;

public class EnvironmentalSprite extends VisibleObject {

	public EnvironmentalSprite(int x, int y, int width, int height, String filename) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setImageWidth(width);
		setImageHeight(height);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/ogre/"+filename+".gif");
	}

}
