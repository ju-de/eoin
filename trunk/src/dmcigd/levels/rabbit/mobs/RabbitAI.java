package dmcigd.levels.rabbit.mobs;

import dmcigd.core.objects.monsters.*;

abstract class RabbitAI extends HitpointHandler {
	
	private int deathClock, deathClockLimit, aiClock, aiClockReset;
	
	abstract void die();
	
	abstract void moveLeft();
	abstract void moveRight();
	
	public void flicker(boolean flicker) {
		setSequence(0);
		if(flicker) {
			setFrame(0);
		}else{
			setFrame(2);
		}
	}
	
	public void idle() {
		setSequence(0);
		setFrameSpeed(0.02f);
		setVX(0);
	}
	
	public void setDeathClockLimit(int deathClockLimit) {
		this.deathClockLimit = deathClockLimit;
	}
	
	public void setAIClockReset(int aiClockReset) {
		this.aiClockReset = aiClockReset;
	}
	
	public boolean isDestroyed() {
		if(isDestroyed && deathClock >= deathClockLimit) {
			return true;
		}
		return false;
	}
	
	public void think() {
		
		if(isDestroyed) {
			//Increment death animation timer
			if(deathClock == 0) {
				die();
			}
			deathClock++;
		}else if(isInvincible()) {
			//Flinch (overrides usual timer)
			if(isKnockedBack()) {
				flicker(isFlickering());
			} else {
				idle();
			}
			aiClock = 0;
		} else {
			//Proceeds with typical AI
			aiClock++;
			if(aiClock >= aiClockReset) {
				//Makes a random decision
				int decision = (int) (Math.random() * 4);
				if(decision == 0) {
					moveLeft();
				}else if(decision == 1) {
					moveRight();
				} else {
					idle();
				}
				aiClock = 0;
			}
		}
		
	}
}
