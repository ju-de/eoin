package dmcigd.levels.lake.mobs;

import dmcigd.core.objects.interfaces.RestableObject;
import dmcigd.core.room.Room;

public class LinearTurtle extends Turtle implements RestableObject {
	
	private int objectClock,clockReset = 0;

	public LinearTurtle(int x, int y, float speed, int distance, Room room) {
		super(x, y, room);
		setVX(speed);
		clockReset = (int) (distance * 32 / speed - 10);
		if(speed < 0) {
			setX(x - 5);
			flipped = true;
		} else {
			setX(x + 1);
		}
		setSequence(1);
	}
	
	public void think() {
		
		if(objectClock < clockReset) {
			objectClock++;
		} else {
			setVX(-getVX());
			flipped = !flipped;
			objectClock = 0;
		}
		
	}

}
