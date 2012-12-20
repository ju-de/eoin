package dmcigd.levels.faerie;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class RisingPlatform extends MovingObject implements RestableObject {
	
	private boolean triggered = false;
	
	private ArrayList<SolidObject> solidObjects;
	
	public boolean isDestroyed() {
		return false;
	}
	
	public RisingPlatform(ArrayList<SolidObject> solidObjects) {
		setX(44 * 32);
		setY(301 * 32);
		setWidth(11 * 32);
		setHeight(24);
		setImageWidth(11 * 32);
		setImageHeight(30);
		setDX(0);
		setDY(0);
		
		setSequence(0);
		setFrame(0);
		
		setCollisionType(CollisionType.SOLID);
		
		setImagePath("objects/faerie/risingplatform.gif");
		
		this.solidObjects = solidObjects;
	}

	public void step() {
		addAcceleration();
		addY(getVY());
		for (SolidObject i: solidObjects) {
			try {
				Entity entity = (Entity) i;
				if(entity.getRestingBlock() != this && entity.getY() <= getY() && getBounds().intersects(entity.getBounds())) {
//					entity.restObject(this);
//					entity.setVY(0);
					entity.setY(getY()-entity.getHeight()-0.2f);
				}
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public void onRest(Entity entity) {
		if(entity.getEntityType() == EntityType.PLAYER) {
			if(!triggered) {
				triggered = true;
				accelerate(0.01f, 2f, Direction.UP);
			}
		}
	}
	
	public void onUnrest(Entity entity) {
		if(entity.getEntityType() == EntityType.PLAYER) {
		}
	}

}
