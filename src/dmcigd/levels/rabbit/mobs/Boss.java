package dmcigd.levels.rabbit.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.room.*;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.*;

public class Boss extends RabbitAI implements RestableObject {
	
	private DialogueHandler dialogueHandler;

	public void die() {
		setCollisionType(CollisionType.NONSOLID);
		setSequence(2);
		setFrameSpeed(0.15f);
		dialogueHandler.setDialogue(new String[][] {
				{"Mach O'Bunny","You're stronger than I thought..."},
				{"Mach O'Bunny","But you haven't seen the last of me! I'll be back, and even stronger than before!"},
				{"KNIGHT","Goodbye, sweet prince!"}
				});
	}

	public void moveLeft() {
		flipped = true;
		setVX(-1);
		setSequence(1);
		setFrameSpeed(0.06f);
	}

	public void moveRight() {
		flipped = false;
		setVX(1);
		setSequence(1);
		setFrameSpeed(0.06f);
	}
	
	public void idle() {
		setSequence(0);
		setFrameSpeed(0.04f);
		setVX(0);
	}
	
	public Boss(int x, int y, PhysicsHandler physicsHandler, DialogueHandler dialogueHandler) {

		setX(x);
		setY(y);
		setWidth(72);
		setHeight(102);
		setImageWidth(96);
		setImageHeight(128);
		
		setSequence(3);
		setFrame(0);

		setFrameLimits(new int[] {2, 4, 7, 7});
		setAnimationLoops(new boolean [] {true, true, false, false});
		setFrameSpeed(0.15f);
		
		setMaxHitpoints(200);
		setKnockback(true);
		
		setDeathClockLimit(300);
		setAIClockReset(50);
		
		setGravity();
		
		setPhysicsHandler(physicsHandler);
		setCollisionType(CollisionType.SOLID);
		setEntityType(EntityType.NONLETHALMONSTER);
		
		setImagePath("objects/rabbit/boss.gif");
		
		flipped = true;
		
		this.dialogueHandler = dialogueHandler;
		dialogueHandler.setDialogue(new String[][] {
				{"Mach O'Bunny","Not so fast! Before you go..."},
				{"Mach O'Bunny","You're going to have to get through me, first!"},
				{"KNIGHT","Wait, what?"}
				});
		
	}
	
	public void step() {
		
		super.step();
		
		if(getSequence() != 3) {
			
			think();
			
			move();
			
			if(!isKnockedBack()) {
				animate();
			}
		
		} else {
			
			animate();
			
			if(getFrame() == 6) {
				dialogueHandler.setDialogue(new String[][] {
						{"Mach O'Bunny","THIS ISN'T EVEN MY FINAL FORM"},
						{"KNIGHT","He's... he's beautiful!\nErm, I mean..."},
						{"KNIGHT","Don't worry about him! He's just as harmless as the rest of the rabbits. You can just jump right over him if you want."}
						});
				idle();
			}
			
		}
	}
	
}
