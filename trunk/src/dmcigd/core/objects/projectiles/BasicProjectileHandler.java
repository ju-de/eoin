package dmcigd.core.objects.projectiles;

import java.awt.Rectangle;
import java.util.ArrayList;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;

public class BasicProjectileHandler extends PhysicsHandler {

	public BasicProjectileHandler(BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(blockMap, solidObjects);
	}
	
	public boolean objectsCollide(Entity entity, Rectangle boundingBox, SolidObject object) {
		
		//Overrides objectsCollide method to disregard boundary case
		//Of inherent object overlap. ALL collisions are counted.
		
		if(boundingBox.intersects(object.getBounds())) {
			return true;
		} else {
			return false;
		}
	}
}
