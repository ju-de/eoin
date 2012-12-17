package dmcigd.levels.ogre;

import dmcigd.core.objects.VisibleObject;

public class Foliage extends VisibleObject {

	public Foliage(int x, int y, int type) {
		setX(x);
		setY(y);
		setWidth(32);
		setHeight(34);
		setImageWidth(40);
		setImageHeight(34);
		
		setSequence(0);
		setFrame(type);
		
		setImagePath("objects/ogre/foliage.gif");
	}

}
