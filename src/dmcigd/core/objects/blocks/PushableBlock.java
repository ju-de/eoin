package dmcigd.core.objects.blocks;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;

import java.util.*;

public class PushableBlock extends Entity implements RestableObject {
	
	public void onRest(EntityType entity) {}
	
	public void onUnrest(EntityType entity) {}
	
	public void onPush(EntityType entityType, int v) {
		if(entityType == EntityType.PLAYER) {
			if(restingBlock != null) {
				setVX((v - restingBlock.getDX())/2);
			} else {
				setVX(v/2);
			}
		}
	}
	
	public boolean isDestroyed() { return false; }
	
	public PushableBlock(int x, int y, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {

		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(32);
		setWidth(32);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(8);
		
		setMapCode("`");
		setImagePath("demo/objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		setBlockMap(blockMap);
		setSolidObjects(solidObjects);
		setEntityType(EntityType.MOVINGBLOCK);
		setGravity();
	}
	
	public void step() {
		move();
		setVX(0);
	}
	
}
