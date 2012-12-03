package dmcigd.levels.lake.mobs;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.interfaces.RestableObject;
import dmcigd.core.room.Room;
import dmcigd.levels.rabbit.mobs.BigMob;

public class Turtle extends BigMob implements RestableObject {

	//Turtle behaves like a big mob in the rabbit level
	
	private Room room;
	
	public void die() {
		super.die();
		setImageWidth(40);
	}
	
	public boolean isDestroyed() {
		boolean returnBoolean = super.isDestroyed();
		if(returnBoolean) {
			room.addSolidObject(new TurtleShell((int) getX(), (int) getY() + 4, room.getPhysicsHandler(), flipped));
		}
		return super.isDestroyed();
	}
	
	public Turtle(int x, int y, Room room) {
		super(x, y, room.getPhysicsHandler());
		
		this.room = room;
		
		setWidth(36);
		setHeight(32);
		setImageWidth(40);
		setImageHeight(34);
		
		setFrameLimits(new int[] {2, 4, 4});
		
		setCollisionType(CollisionType.SOLID);
		
		setImagePath("objects/lake/turtle.gif");
	}


}
