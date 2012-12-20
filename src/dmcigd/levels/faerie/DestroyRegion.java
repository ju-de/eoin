package dmcigd.levels.faerie;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class DestroyRegion extends ObjectCollision implements RestableObject {
	
	private RisingPlatform risingPlatform;
	private ArrayList<SolidObject> solidObjects;
	
	public DestroyRegion(RisingPlatform risingPlatform, ArrayList<SolidObject> solidObjects) {
		setX(40 * 32);
		setY(311 * 32);
		setWidth(20 * 32);
		setHeight(32);
		setImageWidth(0);
		setImageHeight(0);
		setDX(0);
		setDY(0);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/faerie/risingplatform.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		this.risingPlatform = risingPlatform;
		
		this.solidObjects = solidObjects;
	}

	public boolean isDestroyed() {
		return false;
	}

	public void step() {
		setY(risingPlatform.getY() + 320);
		for (SolidObject i: solidObjects) {
			try {
				if(getBounds().intersects(i.getBounds())) ((Entity) i).isDestroyed = true;
			} catch (Exception e) {
			}
		}
	}
	
	
}
