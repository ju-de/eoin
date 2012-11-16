package dmcigd.core.objects.regions;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class RoomWarp extends ObjectCollision implements Region {
	
	String destRoom;

	public RoomWarp (int x, int y, int width, int height, String destRoom) {
		
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		setImageHeight(0);
		setImageWidth(0);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects.gif");
		
		this.destRoom = destRoom;
		
	}
	
	public void onHover(Player player) {
		
		player.setRoom(destRoom);
		
	}

	public void interact(Player player) {}
	
	public void step() {}

}
