package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.room.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.player.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.projectiles.*;

public class BossShard extends Entity implements SolidObject {
	
	private Player player;
	private boolean triggered;
	
	public BossShard(float x, float y, int type, Room room) {
		
		setPhysicsHandler(new BasicProjectileHandler(room.getBlockMap(), room.getSolidObjects()));
		player = room.getPlayer();
		
		setX(x);
		setY(y);
		setWidth(30);
		setHeight(40);
		setImageWidth(0);
		setImageHeight(0);

		setFrameLimits(new int[] {4, 4, 4, 4});
		setAnimationLoops(new boolean [] {false, false, false, false});
		setFrameSpeed(0.1f);
		
		setSequence(type);
		setFrame(0);

		setEntityType(EntityType.DESTROYANIMATION);
		
		setVY(30);
		
		setImagePath("objects/icecave/bossshards.gif");
		
	}
	
	private void trigger() {
		setEntityType(EntityType.PROJECTILE);
		setImageWidth(64);
		setImageHeight(64);
		triggered = true;
	}

	public void step() {
		move();
		if(hitGround) animate();
		if(!triggered && hitGround) {
			trigger();
		} else if(isDead) {
			isDestroyed = true;
		} else if(getX() + 400 < player.getX()) {
			isDestroyed = true;
		}
	}
	
}
