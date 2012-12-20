package dmcigd.levels.faerie;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.*;

public class RisingPlatform extends MovingObject implements RestableObject {
	
	private boolean playerResting = false;
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
				Player player = (Player) i;
				if(!playerResting && player.getY() <= getY() && getBounds().intersects(player.getBounds())) {
					player.restObject(this);
					player.setVY(0);
					player.setY(getY()-30);
				}
			} catch (Exception e) {
				try {
					Entity entity = (Entity) i;
					if(entity.getVY() > 0 && getBounds().intersects(entity.getBounds()) && entity.getRestingBlock() == null) {
						entity.setVY(0.4f);
						entity.setY(getY() - entity.getHeight());
					}
				} catch (Exception e2) {
					//Do nothing
				}
			}
		}
		
	}
	
	public void onRest(Entity entity) {
		if(entity.getEntityType() == EntityType.PLAYER) {
			playerResting = true;
			accelerate(0.01f, 2f, Direction.UP);
		}
	}
	
	public void onUnrest(Entity entity) {
		if(entity.getEntityType() == EntityType.PLAYER) {
			playerResting = false;
		}
	}

}
