package dmcigd.core.objects.player;

import java.util.ArrayList;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.enums.Direction;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

abstract class ControlHandler extends Entity {

	public int jumpDelay = 5;
	
	public boolean isWalking,sprint;
	public Direction walking;
	
	public boolean onLadder,onLadderTop,isClimbing = false;
	public Direction climbing;
	
	public int jumpState = 0;
	
	public ArrayList<Item> items = new ArrayList<Item>();
	public Item heldItem;
	public ArrayList<Region> regions = new ArrayList<Region>();
	
	abstract void handleRegionInteraction(Region region);
	abstract void handleAttack();
	
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
			}
		}
	}
	
	public void climb(boolean isClimbing, Direction direction) {
		this.isClimbing = isClimbing;
		climbing = direction;
	}
	
	public void sprint(boolean sprint) {
		this.sprint = sprint;
	}
	
	public void jump(boolean jumping) {
		if(jumping) {
			if(jumpState < 2 && jumpDelay == 0 && !onLadder) {
				if(!isWalking && isClimbing && climbing == Direction.DOWN) {
					setVY(-4);
				} else {
					setVY(-8);
				}
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
	
	public void interact() {
		
		boolean interacted = false;
		
		//Check for region interaction
		for (Region i : regions) {
			if(getBounds().intersects(i.getBounds())) {
				handleRegionInteraction(i);
				interacted = true;
				break;
			}
		}
		
		if(heldItem != null) {
			
			//If holding an item, check for regions first, don't throw item if in interactive zone
			if(!interacted) {
				//Push item in the direction the player is facing
				if(flipped) {
					heldItem.setVX(-4);
				} else {
					heldItem.setVX(4);
				}
				//Release item into air
				heldItem.setVY(-4);
				heldItem.setHeld(false);
				heldItem = null;
			}
			
		} else {
			
			//Otherwise, check for items to pick up, regardless of interaction
			for (Item i : items) {
				if(getBounds().intersects(i.getBounds())) {
					heldItem = i;
					i.setHeld(true);
					break;
				}
			}
			
			//Only attack if no item is picked up and no interaction takes place
			if(heldItem == null && !interacted) {
				handleAttack();
			}
			
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
