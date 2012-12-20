package dmcigd.levels.faerie.mobs;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class ShieldCharger extends Entity implements RestableObject {
	
	private boolean walking = false;
	private int initInvincibilityCounter = 0;
	private int initInvincibilityLimit = 128;
	private float walkingSpeed = 2.5f;
	
	public ShieldCharger(int x, int y, boolean flipped, PhysicsHandler physicsHandler) {

		setX(x);
		setY(y);
		setWidth(28);
		setHeight(29);
		setImageWidth(32);
		setImageHeight(32);
		
		setDX(0);
		setDY(0);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {5, 4});
		setAnimationLoops(new boolean [] {true, false});
		setFrameSpeed(0.1f);
		
		setEntityType(EntityType.NONLETHALMONSTER);
		setCollisionType(CollisionType.PLATFORM);
		
		setGravity();
		setPhysicsHandler(physicsHandler);
		
		setImagePath("objects/faerie/shieldcharger.gif");
		
		this.flipped = flipped;
		if(flipped) {
			setHeight(28);
		}
	}
	
	public int getFrame() {
		if(!walking && initInvincibilityCounter/4 % 2 == 0) return 5;
		return super.getFrame();
	}

	public void step() {
		move();
		
		if(walking) {
			if(!isDead) {
				if(getRestingBlock() == null || getRestingBlock().getCollisionType() == CollisionType.NONSOLID) {
					die();
				}
			}
			
			//Handles weird collision properties associated with high speeds
		} else {
			//Initial invincibility time
			initInvincibilityCounter++;
			if(initInvincibilityCounter >= initInvincibilityLimit) {
				walking = true;
				setSequence(0);
				setFrame(0);
				if(getRestingBlock() != null && getRestingBlock().getCollisionType() != CollisionType.PLATFORM) {
					if(flipped) {
						accelerate(0.3f,walkingSpeed,Direction.LEFT);
					} else {
						accelerate(0.3f,walkingSpeed,Direction.RIGHT);
					}
				}
			}
			
			for(SolidObject i : getPhysicsHandler().getSolidObjects()) {
				if(getBounds().intersects(i.getBounds()) && i != this) {
					try {
						Entity entity = (Entity) i;
						if(entity.getVY() >= 0 && entity.getEntityType() == EntityType.NONLETHALMONSTER && entity.getRestingBlock() == null) {
							entity.restObject(this);
							entity.setY(getY() - entity.getHeight() + getVY());
						}
					} catch (Exception e) {
						//do nothing
					}
				}
			}
		}
		animate();
	}
	
	//Allow player to kill faerie
	public void die() {
		isDead = true;
		setSequence(1);
		setImageWidth(40);
		setEntityType(EntityType.DESTROYANIMATION);
		setCollisionType(CollisionType.NONSOLID);
		if(flipped) {
			accelerateFrom(walkingSpeed,0,0.03f,Direction.LEFT);
		} else {
			accelerateFrom(walkingSpeed,0,0.03f,Direction.RIGHT);
		}
	}
	
	public boolean onAttack(int damage, boolean swordflipped) {
		if(!isDead && walking) {
			die();
			return true;
		}
		return false;
	}
	
	//Player push methods
	
	public void pushPlayer(Entity entity, float v) {
		if(!isDead && entity.getEntityType() == EntityType.PLAYER) {
			if(flipped) {
				if(entity.getX() + 12 <= getX()) entity.setX(getX() - 21 + v + getAX() - entity.getVX() - entity.getAX());
			} else {
				if(entity.getX() - 20 >= getX()) entity.setX(getX() + 29 + v + getAX() - entity.getVX() - entity.getAX());
			}
		}
	}
	
	public void onPush(Entity entity, float v) {
		pushPlayer(entity, v);
	}
	
	public void pushObject(SolidObject object, float v) {
		try {
			pushPlayer((Entity) object, v);
		} catch(Exception e) {
			// Do nothing
		}
	}
}
