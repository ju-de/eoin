package dmcigd.core.objects.items;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class DoorKey extends Entity implements Item {
	
	int type;
	
	private boolean held = false;
	
	public void setHeld(boolean held) {
		this.held = held;
	}
	
	public DoorKey(int x, int y, int type, PhysicsHandler physicsHandler) {
		
		setX(x + 6);
		setY(y);
		setHeight(16);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(type + 3);
		
		setImagePath("objects.gif");
		
		switch (type) {
			case 4:
				setEntityType(EntityType.KEY4);
				break;
			case 3:
				setEntityType(EntityType.KEY3);
				break;
			case 2:
				setEntityType(EntityType.KEY2);
				break;
			default:
				setEntityType(EntityType.KEY1);
				break;
		}
		
		setPhysicsHandler(physicsHandler);
		setGravity();
		
		this.type = type;
		
	}
	
	public void step() {
		if(!held) {
			move();
			if(hitGround) {
				setVX(0);
			}
		}
	}
}
