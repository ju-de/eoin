package dmcigd.core.objects.player;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;

import java.util.*;

public class Player extends Entity implements RestableObject {
	
	private int jumpState = 0;
	private int jumpDelay = 5;
	private boolean isWalking,sprint;
	private Direction walking,climbing;
	
	private ArrayList<Item> items = new ArrayList<Item>();
	public Item heldItem;

	public void onPush(EntityType entityType, int v) {
		if(entityType == EntityType.MOVINGBLOCK) {
			addX(v);
		}
	}

	public void onRest(EntityType entityType) {}

	public void onUnrest(EntityType entityType) {}
	
	public boolean isDestroyed() { return false; }
	
	public Player(int x, int  y, BlockMap blockMap, ArrayList<SolidObject> solidObjects, ArrayList<Item> items) {
		
		setX(x);
		setY(y);
		setHeight(30);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(24);
		
		setGravity();
		setBlockMap(blockMap);
		setSolidObjects(solidObjects);
		
		this.items = items;
		
		setMapCode("1");
		setImagePath("player.gif");
		
		//SpriteSheet organized as follows:
		//0: Idle [2] [Loops] 0.015f
		//1: Walk [4] [Loops] 0.1f / 0.075f
		//2: Jump [3] [One Shot] 0.2f
		//3: Falling [3] [One Shot] 0.1f
		//4: Climbing [2] [Loops] 0.05f / 0f
		setFrameLimits(new int[] {2,6,3,3,2});
		setAnimationLoops(new boolean[] {true,true,false,false,true});
		
		setSequence(0);
		
		setEntityType(EntityType.PLAYER);
	}
	
	public void walk(boolean isWalking, Direction direction) {
		if(isWalking) {
			this.isWalking = true;  
			walking = direction;
			if(direction == Direction.RIGHT) {
				flipped = false;
			} else {
				flipped = true;
			}
		} else {
			//Smooths out controls in case of overlap with keypresses
			if(walking == direction) {
				this.isWalking = false;
				walking = null;
			}
		}
	}
	
	public void climbUp(boolean isClimbing) {
		this.isClimbing = isClimbing;
		climbing = Direction.UP;
	}
	
	public void keyDown(boolean down) {
		this.sprint = down;
		isClimbing = down;
		climbing = Direction.DOWN;
	}
	
	public void interact() {
		if(heldItem != null) {
			if(flipped) {
				heldItem.setVX(-4);
			} else {
				heldItem.setVX(4);
			}
			heldItem.setVY(-4);
			heldItem = null;
		} else {
			for (Item i : items) {
				if(getBounds().intersects(i.getBounds())) {
					heldItem = i;
				}
			}
		}
	}
	
	public void jump(boolean jumping) {
		if(jumping) {
			if(jumpState < 2 && jumpDelay == 0) {
				setVY(-8);
				jumpState++;
				jumpDelay = 5;
				setFrame(0);
			}
		}else{
			if(getVY() < 0) {
				setVY(0);
			}
		}
	}
	
	public void step() {
		
		//Set movement vectors
		if(isWalking) {
			if(!sprint) {
				accelerate(1.0f, 2.0f, walking);
			} else {
				accelerate(1.0f, 4.0f, walking);
			}
		}else{
			accelerate(0.0f, 0.0f, Direction.RIGHT);
			setVX(0);
		}
		if(isClimbing && onLadder) {
			if(climbing == Direction.UP) {
				setVY(-2);
			}else {
				setVY(2);
			}
		}
		
		//Step
		move();
		
		//Animate Character
		if(isFalling) {
			setFrameSpeed(0.1f);
			setSequence(3);
		} else if(jumpState > 0) {
			setFrameSpeed(0.2f);
			setSequence(2);
		} else if (onLadder) {
			if(isClimbing) {
				setFrameSpeed(0.05f);
			}else {
				setFrameSpeed(0);
			}
			setSequence(4);
		} else if (isWalking) {
			if(sprint) {
				setFrameSpeed(0.1f);
			} else {
				setFrameSpeed(0.075f);
			}
			setSequence(1);
		} else {
			setFrameSpeed(0.015f);
			setSequence(0);
		}
		
		animate();
		
		//Reset jump counter after player hits the ground
		if(hitGround || onLadder) {
			jumpState = 0;
		}
		
		//Counts falling at terminal velocity as a jump
		//If falling, player should not be allowed to defy physics even further and jump a second time
		//Period of acceleration is given as a grace period to give player time to react
		if(isFalling && getVY() >= 5 && jumpState == 0) {
			jumpState = 1;
		}
		
		//Jump delay to prevent accidentally double jumping straight away
		if(jumpDelay > 0) {
			jumpDelay--;
		}
		
		//Carries item
		if(heldItem != null) {
			heldItem.setX(getX());
			heldItem.setY(getY() + 8);
		}
	}
}
