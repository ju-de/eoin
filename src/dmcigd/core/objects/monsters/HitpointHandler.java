package dmcigd.core.objects.monsters;

import dmcigd.core.enums.Direction;
import dmcigd.core.objects.*;

public class HitpointHandler extends Entity {
	
	private int maxHitpoints,hitpoints = 1;
	
	private boolean invincible,flicker,knockback,knockedBack = false;
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
	public boolean isKnockedBack() {
		return knockedBack;
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
	public void knockback(int damage, boolean swordflipped) {
		if(knockback) {
			
			float knockbackSpeed;
			
			//Knockback Speed = Coefficient * (Base Knockback - Monster Resistance)
			knockbackSpeed = 0.5f * (damage - (maxHitpoints / damage));
			
			//Minimum Knockback Speed
			if(knockbackSpeed < 0.2f) {
				knockbackSpeed = 0.2f;
			}
			
			if(swordflipped) {
				setVX(-knockbackSpeed);
				accelerate(2 * knockbackSpeed/invincibilityCounterReset, 0.0f, Direction.RIGHT);
			}else{
				setVX(knockbackSpeed);
				accelerate(2 * knockbackSpeed/invincibilityCounterReset, 0.0f, Direction.LEFT);
			}
			knockedBack = true;
		}
	}
	
	public boolean onAttack(int damage, boolean swordflipped) {
		if(!isDestroyed && !invincible) {
			hitpoints = hitpoints - damage;
			setInvincibility(true);
			knockback(damage,swordflipped);
		}
		
		if(!isDestroyed && hitpoints <= 0) {
			isDestroyed = true;
			return true;
		}
		
		return false;
	}
	
	//Step
	public void step() {
		
		if(invincible) {
			
			invincibilityCounter++;
			
			//Stop knockback halfway through invincibility
			if(invincibilityCounter >= invincibilityCounterReset/2 && knockback) {
				setVX(0);
				knockedBack = false;
				
				//Resets acceleration vectors
				accelerate(0, 32, Direction.LEFT);
				accelerate(0, 32, Direction.RIGHT);
			}
			
			if(invincibilityCounter >= invincibilityCounterReset) {
				setInvincibility(false);
			}
			
			//Flicker every eight ticks
			if(invincibilityCounter/4 % 2 == 0) {
				flicker = true;
			}else{
				flicker = false;
			}
			
		}else{
			
			flicker = false;
			
		}
	}
	
}
