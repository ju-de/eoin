package dmcigd.core.objects.monsters;

import dmcigd.core.objects.*;

public class HitpointHandler extends Entity {
	
	private int maxHitpoints,hitpoints = 1;
	
	private boolean invincible,flicker,knockback = false;
	private int invincibilityCounter = 0;
	private int invincibilityCounterReset = 30;
	
	//Public Getters
	public int getMaxHitpoints() {
		return maxHitpoints;
	}
	public int getHitpoints() {
		return hitpoints;
	}
	
	
	public boolean isInvincible() {
		return invincible;
	}
	public boolean isFlickering() {
		return flicker;
	}
	
	//Public Setters
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
	
	public void setKnockback(boolean knockback) {
		this.knockback = knockback;
	}
	
	//Events
	public void knockback(int damage, boolean flipped) {
		if(knockback) {
			
			float knockbackSpeed;
			
			//Knockback Speed = Coefficient * (Base Knockback - Monster Resistance)
			knockbackSpeed = 0.4f * (damage - (maxHitpoints / damage));
			
			//Minimum Knockback Speed
			if(knockbackSpeed < 0.2f) {
				knockbackSpeed = 0.2f;
			}
			
			if(flipped) {
				setVX(-knockbackSpeed);
				setAX(2 * knockbackSpeed/invincibilityCounterReset);
			}else{
				setVX(knockbackSpeed);
				setAX(-2 * knockbackSpeed/invincibilityCounterReset);
			}
		}
	}
	
	public void onAttack(int damage, boolean flipped) {
		if(!invincible) {
			hitpoints = hitpoints - damage;
			setInvincibility(true);
			knockback(damage,flipped);
		}
	}
	
	//Step
	public void step() {
		
		if(hitpoints <= 0) {
			getPhysicsHandler().isDestroyed = true;
		}
		
		if(invincible) {
			
			invincibilityCounter++;
			
			//Stop knockback halfway through invincibility
			if(invincibilityCounter >= invincibilityCounterReset/2 && knockback) {
				setVX(0);
				setAX(0);
			}
			
			if(invincibilityCounter >= invincibilityCounterReset) {
				setInvincibility(false);
			}
			
			//Flicker every eight ticks
			if(invincibilityCounter/8 % 2 == 0) {
				flicker = true;
			}else{
				flicker = false;
			}
			
		}else{
			
			flicker = false;
			
		}
	}
	
}
