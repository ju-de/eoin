package dmcigd.core.objects.regions;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class Passage extends ObjectCollision implements Region {
	
	int destX;
	int destY;

	public Passage (int x, int y, int destX, int destY) {
		
		setX(x + 6);
		setY(y);
		setHeight(30);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(5);
		setFrame(9);
		
		setMapCode("`");
		setImagePath("objects.gif");
		
		this.destX = destX + 3;
		this.destY = destY;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		player.setX(destX);
		player.setY(destY);
	}
	
	public void step() {}

}
