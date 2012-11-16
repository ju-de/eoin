package dmcigd.core.objects.regions;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class Warp extends ObjectCollision implements Region {
	
	int destX;
	int destY;

	public Warp (int x, int y, int width, int height, int destX, int destY) {
		
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		setImageHeight(0);
		setImageWidth(0);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects.gif");
		
		this.destX = destX;
		this.destY = destY;
		
	}
	
	public void onHover(Player player) {
		player.setX(destX);
		player.setY(destY);
	}

	public void interact(Player player) {}
	
	public void step() {}
}
