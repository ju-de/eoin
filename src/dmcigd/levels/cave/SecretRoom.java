package dmcigd.levels.cave;

import dmcigd.core.objects.*;

public class SecretRoom extends VisibleObject {

	public SecretRoom(int x, int y) {
		setX(x);
		setY(y);
		setWidth(274);
		setHeight(160);
		setImageWidth(274);
		setImageHeight(162);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/cave/secretroom.gif");
	}
}
