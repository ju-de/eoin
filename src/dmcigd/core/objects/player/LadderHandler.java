package dmcigd.core.objects.player;

import java.util.ArrayList;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.SolidObject;
import dmcigd.core.objects.maps.BlockMap;

public class LadderHandler extends PhysicsHandler {
	
	public LadderHandler(BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(blockMap, solidObjects);
	}

	//Account for ladder top position
	public void rest(Entity entity, CollisionType collisionType) {
		
		ControlHandler e = (ControlHandler) entity;
	
		//Determine entity states based on resting block
		switch(collisionType) {
		
			//Dead
			case DESTROY:
				e.isDestroyed = true;
				break;
			case KILL:
				e.isDead = true;
				break;

			//On ladder
			case SOLIDLADDER:
				e.onLadderTop = true;
				//Falls through to behave like a SOLID block
			//On ground
			case PLATFORM:
			case SOLID:
				e.hitGround = true;
				e.isFalling = false;
				break;
			//In air
			default:
				break;
		}
	
	}
	
	//Checks downward collision for ladders
	public void checkBlockMapCollisionDown(Entity entity, float v) {
		
		ControlHandler e = (ControlHandler) entity;
		
		//Move Down
		switch(tileCollisionType(entity, v, Direction.DOWN)) {
		
			//Dead
			case DESTROY:
				e.isDestroyed = true;
				break;
			case KILL:
				e.isDead = true;
				break;
		
			case WATER:
			case NONSOLID:
				e.isFalling = true;
				checkSolidObjectCollisionDown(entity, v);
				break;
				
			//Climb down
			case NONSOLIDLADDER:
			case SOLIDLADDER:
				if(e.onLadder || (e.isClimbing && e.climbing == Direction.DOWN)) {
					checkSolidObjectCollisionDown(entity, v - 0.4f);
					e.setVY(0);
					break;
				}
				
			case PLATFORM:
				if(e.isClimbing && e.climbing == Direction.DOWN && e.jumpState > 0) {
					checkSolidObjectCollisionDown(entity, v);
					break;
				}
			//Hit ground
			default:
				blockMapCollision(entity, Direction.DOWN);
				entity.setVY(0);
				rest(entity, tileCollisionType(entity, v, Direction.DOWN));
				break;
		}
	}
}
