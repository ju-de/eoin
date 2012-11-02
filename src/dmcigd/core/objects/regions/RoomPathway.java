package dmcigd.core.objects.regions;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class RoomPathway extends ObjectCollision implements Region {
	
	String destLevel, destRoom;

	public RoomPathway (int x, int y, String destLevel, String destRoom) {
		
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
		
		this.destLevel = destLevel;
		this.destRoom = destRoom;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		
		player.setRoom(destLevel, destRoom);
		
	}
	
	public void step() {}

}
