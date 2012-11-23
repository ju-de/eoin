package dmcigd.core.objects.player;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;

abstract class LadderHandler extends Entity {
	
	public boolean onLadder,onLadderTop,isClimbing = false;
	public Direction climbing;
	
	public int jumpState = 0;
	
	//Account for ladder top position
	public void rest(CollisionType collisionType) {
	
		//Determine entity states based on resting block
		switch(collisionType) {
		
			//Dead
			case DESTROY:
				isDestroyed = true;
				break;
			case KILL:
				isDead = true;
				break;

			//On ladder
			case SOLIDLADDER:
				onLadderTop = true;
				//Falls through to behave like a SOLID block
			//On ground
			case PLATFORM:
			case SOLID:
				hitGround = true;
				isFalling = false;
				break;
			//In air
			default:
				break;
		}
	
	}
	
	//Checks downward collision for ladders
	public void checkBlockMapCollisionDown(int v) {
		//Move Down
		switch(tileCollisionType(v, Direction.DOWN)) {
		
			//Dead
			case DESTROY:
				isDestroyed = true;
				break;
			case KILL:
				isDead = true;
				break;
		
			case WATER:
			case NONSOLID:
				isFalling = true;
				checkSolidObjectCollisionDown(v);
				break;
				
			//Climb down
			case NONSOLIDLADDER:
			case SOLIDLADDER:
				if(onLadder || (isClimbing && climbing == Direction.DOWN)) {
					checkSolidObjectCollisionDown(v);
					setVY(0);
					break;
				}
				
			case PLATFORM:
				if(isClimbing && climbing == Direction.DOWN && jumpState > 0) {
					checkSolidObjectCollisionDown(v);
					break;
				}
			//Hit ground
			default:
				blockMapCollision(Direction.DOWN);
				setVY(0);
				rest(tileCollisionType(v, Direction.DOWN));
				break;
		}
	}
	
	public void move() {
		onLadderTop = false;
		
		super.move();
		
		//Checks for ladders
		if(backBlock == CollisionType.NONSOLIDLADDER || backBlock == CollisionType.SOLIDLADDER) {
			onLadder = true;
		} else {
			onLadder = false;
		}
	}
}
