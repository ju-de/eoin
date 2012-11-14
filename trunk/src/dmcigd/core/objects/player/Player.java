package dmcigd.core.objects.player;

import dmcigd.core.enums.*;
import dmcigd.core.objects.Entity;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;

import java.util.*;

public class Player extends ControlHandler implements SolidObject {
	
	private String room;
	
	public Sword sword;
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public boolean isDestroyed() { return false; }
	
	public void handleRegionInteraction (Region region) {
		region.interact(this);
	}
	
	public void handleAttack() {
		sword.attack();
	}
	
	public void onPush(Entity entity, int v) {
		super.onPush(entity, v);
		if(entity.getEntityType() == EntityType.PROJECTILE) {
			isDead = true;
		}
	}
	
	public Player(int x, int  y, BlockMap blockMap, ArrayList<SolidObject> solidObjects, ArrayList<Item> items, ArrayList<Region> regions) {
		
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
		this.regions = regions;
		
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
		
		//Create Sword
		sword = new Sword(x, y, solidObjects);
	}
	
	public void animate() {
		
		//Animate Character
		if (onLadder) {
			if(isClimbing) {
				setFrameSpeed(0.05f);
			}else {
				setFrameSpeed(0);
			}
			setSequence(4);
		} else if(isFalling) {
			setFrameSpeed(0.1f);
			setSequence(3);
		} else if(jumpState > 0) {
			setFrameSpeed(0.2f);
			setSequence(2);
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
		
		super.animate();
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
		
		//Set movement vectors for climbing
		if(isClimbing && (onLadder || climbing == Direction.DOWN && onLadderTop)) {
			if(climbing == Direction.UP) {
				setVY(-2);
			}else {
				setVY(2);
			}
		}
		
		//Step
		move();
		
		//Activate hover status of nearby regions
		for (Region i : regions) {
			if(getBounds().intersects(i.getBounds())) {
				i.onHover(this);
			}
		}
		
		animate();
		
		//Reset jump count
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
		
		if(heldItem != null) {
			//Carries item
			heldItem.setX(getX());
			heldItem.setY(getY() + 14);
		} else {
			//Carries sword
			sword.setPosition(getX(),getY());
			sword.setLadder(onLadder);
			sword.flipped = flipped;
		}
		
		sword.step();
	}
}
