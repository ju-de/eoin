package dmcigd.core.objects.platforms;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class MovingPlatform extends MovingObject implements RestableObject {
	
	private int objectClock = 0;
	
	private String mapCode;
	private String imagePath;
	
	//Interface Getters
	
	public CollisionType isSolid() {
		return CollisionType.PLATFORM;
	}
	public String getMapCode() {
		return mapCode;
	}
	public String getImagePath() {
		return imagePath;
	}
	public int getDX() {
		return 0;
	}
	public int getDY() {
		return 0;
	}
	
	public MovingPlatform(String tileSheet) {
		mapCode = "q";
	}
	
	public boolean isVisible(int x, int y) {
		return true;
	}
	
	public void step() {
		objectClock++;
	}
}
