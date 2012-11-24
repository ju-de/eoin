package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.*;

import java.awt.Rectangle;
import java.util.ArrayList;

public class PhysicsHandler {
	
	private BlockMap blockMap;
	private ArrayList<SolidObject> solidObjects;

	//Constructor sets blockMap and solidObjects
	public PhysicsHandler(BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		this.blockMap = blockMap;
		this.solidObjects = solidObjects;
	}
	
	//Getters
	public BlockMap getBlockMap() {
		return blockMap;
	}
	public ArrayList<SolidObject> getSolidObjects() {
		return solidObjects;
	}
	
//BLOCKMAP COLLISION
	
	//Returns collision type of tile of destination block
	public CollisionType tileCollisionType(Entity entity, int v, Direction direction) {
		switch (direction) {
			case DOWN:
			case UP:
				return blockMap.collidesY(entity.getX(), entity.getY(), v, entity.getWidth(), entity.getHeight(), direction);
			default:
				return blockMap.collidesX(entity.getX(), entity.getY(), v, entity.getWidth(), entity.getHeight(), direction);
		}
	}
	
	//Places entity at edge of tile (farthest accessible point) used in case of obstruction
	public void blockMapCollision(Entity entity, Direction direction) {
		switch (direction) {
			case DOWN:
				entity.setVY(0);
			case UP:
				entity.setY(blockMap.rowEdge(entity.getY(), entity.getHeight(), direction));
				break;
			default:
				entity.setX(blockMap.colEdge(entity.getX(), entity.getWidth(), direction));
				break;
		}
	}
	
	//Checks downward collision (behaves differently from other three directions)
	public void checkBlockMapCollisionDown(Entity entity, int v) {
		
		//Move Down
		switch(tileCollisionType(entity, v, Direction.DOWN)) {
		
			//Fall down
			case WATER:
			case NONSOLIDLADDER:
			case NONSOLID:
				entity.isFalling = true;
				checkSolidObjectCollisionDown(entity, v);
				break;
				
			case DESTROY:
				entity.isDestroyed = true;
			case KILL:
				entity.isDead = true;
			//Hit ground
			default:
				blockMapCollision(entity, Direction.DOWN);
				entity.setVY(0);
				rest(entity, tileCollisionType(entity, v, Direction.DOWN));
				break;
				
		}
		
	}
	
	//Checks all other types of collision
	public void checkBlockMapCollision(Entity entity, int v, Direction direction) {
		
		CollisionType collidingBlock = tileCollisionType(entity, v, direction);
		
		//If object is not a solid block, move through (all other objects allow horizontal movement)
		if(collidingBlock.getPriority() > 1) {
			
			if(direction == Direction.UP) {
				checkSolidObjectCollisionUp(entity, v);
			} else {
				checkSolidObjectCollisionX(entity, v);
			}
			
		} else {
			
			if(collidingBlock == CollisionType.DESTROY) {
				entity.isDestroyed = true;
			}
			
			if(collidingBlock == CollisionType.KILL) {
				entity.isDead = true;
			}
			
			blockMapCollision(entity, direction);
			if(direction != Direction.UP) {
				entity.setVX(0);
			}
		}
	}
	
//OBJECT COLLISION
	
	public boolean objectsCollide(Entity entity, Rectangle boundingBox, SolidObject object) {

        //Checks if objects overlap
        //And that player collided into object, object was not formed over player
        //Actions that take place when an object forms over the player should be handled
        //By the object itself, not in a collision check

        if (boundingBox.intersects(object.getBounds()) && (entity.getRestingBlock() == object || !entity.getBounds().intersects(object.getBounds()))) {
            return true;
        } else {
            return false;
        }
    }

    public void checkSolidObjectCollisionDown(Entity entity, int v) {
    	
    	RestableObject restingBlockCheck = null;

        boolean obstructMovement = false;

        //Get bounding box of destination
        //v+1 is necessary to deal with resting objects
        Rectangle boundingBox = entity.getBounds(0, v + 1);

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(entity, boundingBox, i)) {
                switch (i.getCollisionType()) {
                    case PLATFORM:
                    case SOLID:
                        restingBlockCheck = (RestableObject) i;
                        entity.setY(i.getY() - entity.getHeight());
                        entity.setVY(0);
                        obstructMovement = true;
                    default:
                        break;
                }
            }
        }
        
		if(entity.getRestingBlock() != restingBlockCheck) {
			if(restingBlockCheck == null) {
				entity.unrestObject();
			} else {
				entity.restObject(restingBlockCheck);
			}
		}

        if (!obstructMovement) {
            //Advance normally
        	entity.addY(v);
        }
    }

    public void checkSolidObjectCollisionUp(Entity entity, int v) {
    	
    	RestableObject restingBlockCheck = null;

        boolean obstructMovement = false;

        //Get bounding box of destination
        //v+1 is necessary to deal with resting objects (while being pushed up)
        Rectangle boundingBox;
        if(entity.getRestingBlock() != null && entity.getRestingBlock().getDY() < 0) {
            boundingBox = entity.getBounds(0, v + 1);
        } else {
        	boundingBox = entity.getBounds(0, v);
    	}

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(entity, boundingBox, i)) {
                if (entity.getRestingBlock() == i) {
                    //Check if object is being pushed up by resting block
                    restingBlockCheck = (RestableObject) i;
                } else {
                    switch (i.getCollisionType()) {
                        case SOLID:
                            //Hit ceiling
                        	entity.setY(i.getY() + i.getHeight());
                            obstructMovement = true;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        
		if(entity.getRestingBlock() != restingBlockCheck) {
			if(restingBlockCheck == null) {
				entity.unrestObject();
			} else {
				entity.restObject(restingBlockCheck);
			}
		}

        if (!obstructMovement) {
            //Advance normally
        	entity.addY(v);
        }
    }

    public void checkSolidObjectCollisionX(Entity entity, int v) {

        boolean obstructMovement = false;

        //Get bounding box of destination
        Rectangle boundingBox = entity.getBounds(v, 0);

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(entity, boundingBox, i)) {

                pushObject(entity, i, v);

                //Determine collision type
                switch (i.getCollisionType()) {
                    case SOLID:
                        if (v > 0) {
                            //Push against left edge (if moving right)
                        	entity.setX(i.getX() - entity.getWidth());
                        } else {
                            //Push against right edge (if moving left)
                        	entity.setX(i.getX() + i.getWidth());
                        }
                        obstructMovement = true;
                        break;
                    default:
                        break;
                }
            }
        }

        if (!obstructMovement) {
            //Advance normally
        	entity.addX(v);
        }
    }
	
//MOVEMENT
    public void moveDown(Entity entity, int vy) {
    	checkBlockMapCollisionDown(entity, vy);
		if(entity.getRestingBlock() != null) {
			rest(entity, entity.getRestingBlock().getCollisionType());
		}
    }
    
    public void moveUp(Entity entity, int vy) {
    	checkBlockMapCollision(entity, vy, Direction.UP);
    }
    
    public void moveX(Entity entity, int vx) {
    	if(vx >= 0) {
        	checkBlockMapCollision(entity, vx, Direction.RIGHT);
    	}else{
        	checkBlockMapCollision(entity, vx, Direction.LEFT);
    	}
    }
   
//SUPPLEMENTARY METHODS
	
    //Strictly handles collisionType, see restObject() for handling RestableObjects
    public void rest(Entity entity, CollisionType collisionType) {

        //Determine entity states based on resting block
        switch (collisionType) {

            case DESTROY:
                entity.isDestroyed = true;
                break;

            case KILL:
                entity.isDead = true;
            //Falls through so death blocks are treated like solid blocks

            //On ground
            case PLATFORM:
            case SOLID:
            case SOLIDLADDER:
                entity.hitGround = true;
                entity.isFalling = false;
                break;

            //Fall through
            default:
                break;
        }

    }
    
    public void pushObject(Entity entity, SolidObject object, int v) {
        entity.pushObject(object, v);
    }
	
}
