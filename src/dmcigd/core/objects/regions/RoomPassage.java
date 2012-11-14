package dmcigd.core.objects.regions;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class RoomPassage extends ObjectCollision implements Region {
	
	String destRoom;

	public RoomPassage (int x, int y, String destRoom) {
		
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
		
		this.destRoom = destRoom;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) {
		
		player.setRoom(destRoom);
		
	}
	
	public void step() {}

}
