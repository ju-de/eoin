package dmcigd.core.objects.player;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

import java.util.ArrayList;

public class Sword extends ObjectCollision {
	
	private int baseX,baseY;
	private boolean attacking,onLadder = false;
	private int damage = 10;
	private ArrayList<SolidObject> solidObjects;
	private int killCount = 0;
	
	//Public Getters
	public int getKillCount() {
		return killCount;
	}
	
	//Public setters
	public void setPosition(int x, int y) {
		baseX = x;
		baseY = y + 16;
	}
	public void setLadder(boolean onLadder) {
		this.onLadder = onLadder;
	}
	public void attack() {
		if(!onLadder && !attacking) {
			this.attacking = true;
			setSequence(5);
			setFrame(0);
		}
	}
	
	public Sword(int x, int y, ArrayList<SolidObject> solidObjects) {
		
		baseX = x;
		baseY = y + 16;
		
		setX(baseX);
		setY(baseY);
		setHeight(14);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(32);
		
		setMapCode("`");
		setImagePath("objects.gif");
		
		this.solidObjects = solidObjects;
		
		setSequence(5);
		setFrame(0);
		
		setFrameLimits(new int[] {2,6,10,10,10,6});
		setAnimationLoops(new boolean[] {false,false,false,false,false,false});
		setFrameSpeed(0.4f);
		
	}
	
	public void checkCollision() {
		//Loop through solid objects
		for(SolidObject i : solidObjects) {
			if(getBounds().intersects(i.getBounds())) {
				i.onAttack(damage);
				
				//Increments the KillCount
				if(i.isDestroyed()) {
					killCount++;
				}
			}
		}
	}
	
	public void step() {
		if(onLadder) {
			setSequence(5);
			setFrame(1);
			setX(baseX);
			setY(baseY);
		}else if(attacking) {
			
			//Set Position
			if(flipped) {
				setX(baseX - (getFrame()*2));
			} else {
				setX(baseX + (getFrame()*2));
			}
			setY(baseY);
			
			//Attack all collided objects
			checkCollision();
			
			//Animate
			animate();
			if(getFrame() == 5) {
				attacking = false;
			}
		}else {
			setSequence(5);
			setFrame(0);
			setX(baseX);
			setY(baseY);
		}
	}
}
