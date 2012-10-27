package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

import java.awt.Rectangle;
import java.util.ArrayList;

public class EntityObjectCollider extends MovingObject {
	
	private ArrayList<SolidObject> solidObjects;
	
	private EntityType entityType;
	
	public RestableObject restingBlock,restingBlockCheck;
	
	//Public getters
	public EntityType getEntityType() {
		return entityType;
	}
	
	//Public setters
	public void setSolidObjects(ArrayList<SolidObject> solidObjects) {
		this.solidObjects = solidObjects;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	public boolean objectsCollide(Rectangle boundingBox, SolidObject object) {
		
		//Checks if objects overlap
		//And that player collided into object, object was not formed over player
		//Actions that take place when an object forms over the player should be handled
		//By the object itself, not in a collision check
		
		if(boundingBox.intersects(object.getBounds()) && (restingBlock == object || !getBounds().intersects(object.getBounds()))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void checkSolidObjectCollisionDown(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(0, v+1);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				switch(i.getCollisionType()) {
					case PLATFORM:
						//Check if object is not inside of platform
						if(getY() + getHeight() > i.getY()) {
							break;
						}
					case SOLID:
						setY(i.getY() - getHeight());
						restingBlockCheck = (RestableObject) i;
						setVY(0);
						obstructMovement = true;
					default:
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addY(v);
		}
	}
	public void checkSolidObjectCollisionUp(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(0, v+1);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				switch(i.getCollisionType()) {
					case PLATFORM:
						if(restingBlock != i) {
							break;
						}
					case SOLID:
						//Check if object is being pushed up by resting block
						if(restingBlock == i) {
							setY(i.getY() - getHeight() + 1);
							restingBlockCheck = (RestableObject) i;
							setVY(0);
							break;
						} else {
							//Otherwise, hit ceiling
							setY(i.getY() + i.getHeight());
							obstructMovement = true;
						}
					default:
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addY(v);
		}
	}
	
	public void checkSolidObjectCollisionX(int v) {
		
		boolean obstructMovement = false;
		
		//Get bounding box of destination
		Rectangle boundingBox = getBounds(v, 0);
		
		//Loop through all solid objects
		for (SolidObject i : solidObjects) {
			
			//Check for collision
			if(objectsCollide(boundingBox, i)) {
				
				//Push against block
				i.onPush(entityType, v);
				
				//Determine collision type
				switch (i.getCollisionType()) {
					case SOLID:
						if(v > 0) {
							//Push against left edge (if moving right)
							setX(i.getX() - getWidth());
						} else {
							//Push against right edge (if moving left)
							setX(i.getX() + i.getWidth());
						}
						obstructMovement = true;
						break;
					default:
						break;
				}
			}
		}
		
		if(!obstructMovement) {
			//Advance normally
			addX(v);
		}
	}
	
}
