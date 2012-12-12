package dmcigd.levels.icecave;

import dmcigd.core.objects.interfaces.RestableObject;

public class SwitchWall extends SwitchBlock implements RestableObject {

	public SwitchWall(int x, int y) {
		super(x, y, 1);
		
		setX(x + 12);
		setHeight(30);
		setWidth(8);
		setImageHeight(32);
		setImageWidth(12);
		
		setImagePath("objects/icecave/switchwall.gif");
	}

}
