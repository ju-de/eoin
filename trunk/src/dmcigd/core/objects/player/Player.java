package dmcigd.core.objects.player;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;

public class Player extends AnimateObject {
	
	private int jumpState = 0;
	private int jumpDelay = 5;
	private int facing = 0;
	private boolean isWalking,sprint;
	private Direction walking,climbing;
	
	public Player(int x, int  y, BlockMap blockMap) {
		setX(x);
		setY(y);
		setHeight(30);
		setWidth(20);
		setGravity();
		setBlockMap(blockMap);
		
		//SpriteSheet organized as follows:
		//0: Idle Right [2] [Loops] 0.015f
		//1: Idle Left [2] [Loops] 0.01f
		//2: Walk Right [4] [Loops] 0.1f / 0.075f
		//3: Walk Left [4] [Loops] 0.1f / 0.075f
		//4: Jump Right [3] [One Shot] 0.2f
		//5: Jump Left [3] [One Shot] 0.2f
		//6: Falling Right [3] [One Shot] 0.1f
		//7: Falling Left [3] [One Shot] 0.1f
		//8: Climbing [2] [Loops] 0.05f / 0f
		setFrameLimits(new int[] {2,2,6,6,3,3,3,3,2});
		setAnimationLoops(new boolean[] {true,true,true,true,false,false,false,false,true});
		
		setSequence(0);
	}
	
	public void walk(boolean isWalking, Direction direction) {
		if(isWalking) {
			this.isWalking = true;  
			walking = direction;
			if(direction == Direction.RIGHT) {
				facing = 0;
			} else {
				facing = 1;
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
			setSequence(6+facing);
		} else if(jumpState > 0) {
			setFrameSpeed(0.2f);
			setSequence(4+facing);
		} else if (onLadder) {
			if(isClimbing) {
				setFrameSpeed(0.05f);
			}else {
				setFrameSpeed(0);
			}
			setSequence(8);
		} else if (isWalking) {
			if(sprint) {
				setFrameSpeed(0.1f);
			} else {
				setFrameSpeed(0.075f);
			}
			setSequence(2+facing);
		} else {
			setFrameSpeed(0.015f);
			setSequence(0+facing);
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
	}
}