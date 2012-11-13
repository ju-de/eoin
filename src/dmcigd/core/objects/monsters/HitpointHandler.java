package dmcigd.core.objects.monsters;

import dmcigd.core.objects.*;

public class HitpointHandler extends Entity {
	
	private int maxHitpoints,hitpoints = 1;
	
	private boolean invincible = false;
	private int invincibilityCounter = 0;
	private int invincibilityCounterReset = 30;
	
	public int getMaxHitpoints() {
		return maxHitpoints;
	}
	public int getHitpoints() {
		return hitpoints;
	}
	
	public void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
		hitpoints = maxHitpoints;
	}
	
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}
	
	public void setInvincibility(boolean invincible) {
		this.invincible = invincible;
		invincibilityCounter = 0;
	}
	
	public void setInvincibilityCounterReset(int invincibilityCounterReset) {
		this.invincibilityCounterReset = invincibilityCounterReset;
	}
	
	public void onAttack(int damage) {
		if(!invincible) {
			hitpoints = hitpoints - damage;
			setInvincibility(true);
		}
	}
	
	public void step() {
		if(hitpoints <= 0) {
			isDestroyed = true;
		}
		if(invincible) {
			invincibilityCounter++;
			if(invincibilityCounter >= invincibilityCounterReset) {
				setInvincibility(false);
			}
		}
	}
	
}
