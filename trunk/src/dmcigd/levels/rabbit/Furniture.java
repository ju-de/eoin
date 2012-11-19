package dmcigd.levels.rabbit;

import dmcigd.core.objects.VisibleObject;

public class Furniture extends VisibleObject {
	
	public Furniture(int x, int y, int sequence, int frame, boolean flipped) {
		setX(x);
		setY(y);
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(sequence);
		setFrame(frame);
		
		setImagePath("objects/rabbit/furniture.gif");
		
		this.flipped = flipped;
	}
	
}
