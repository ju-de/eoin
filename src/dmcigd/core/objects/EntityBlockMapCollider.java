package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.maps.BlockMap;

public class EntityBlockMapCollider extends EntityObjectCollider {
	
	public BlockMap blockMap;
	
	//Creates entity statuses for further manipulation
	public boolean hitGround,isFalling,onLadder,isClimbing,isDead,inWater = false;
	
	//Public setters
	public void setBlockMap(BlockMap blockMap) {
		this.blockMap = blockMap;
	}
	
	//Checks downward collision (behaves differently from other three directions)
	public void checkBlockMapCollisionDown(int v) {
		//Move Down
		switch(tileCollisionType(v, Direction.DOWN)) {
			//Fall down
			case NONSOLID:
			case WATER:
				isFalling = true;
				checkSolidObjectCollisionDown(v);
				break;
				
			//Climb down
			case LADDER:
				if(isClimbing) {
					checkSolidObjectCollisionDown(v);
				} else {
					setVY(0);
				}
				break;
				
			//Destroy
			case DESTROY:
				isDead = true;
				break;
				
			//Hit ground
			default:
				blockMapCollision(v, Direction.DOWN);
				break;
		}
	}
	
	//Checks all other types of collision
	public void checkBlockMapCollision(int v, Direction direction) {
		
		switch(tileCollisionType(v, direction)) {
				
			//Move
			case NONSOLID:
			case WATER:
			case LADDER:
			case PLATFORM:
				if(direction == Direction.UP) {
					checkSolidObjectCollisionUp(v);
				} else {
					checkSolidObjectCollisionX(v);
				}
				break;
				
			//Destroy
			case DESTROY:
				isDead = true;
				
			//Hit solid object
			default:
				blockMapCollision(v, direction);
				break;
		}
	}
	
	//Returns collision type of tile of destination block
	public CollisionType tileCollisionType(int v, Direction direction) {
			switch (direction) {
			case DOWN:
			case UP:
				return blockMap.collidesY(getX(), getY(), v, getWidth(), getHeight(), direction);
			default:
				return blockMap.collidesX(getX(), getY(), v, getWidth(), getHeight(), direction);
		}
	}
	
	//Places entity at edge of tile (farthest accessible point) used in case of obstruction
	public void blockMapCollision(int v, Direction direction) {
		switch (direction) {
			case DOWN:
				setVY(0);
			case UP:
				setY(blockMap.rowEdge(getY(), getHeight(), direction));
				break;
			default:
				setX(blockMap.colEdge(getX(), getWidth(), direction));
				break;
		}
	}
	
}
