package dmcigd.core.objects.monsters;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.Entity;

public class LethalityHandler extends HitpointHandler {
	
	private boolean lethalOnPush,lethalOnRest = false;
	
	//Public Setters
	public void setLethalOnPush(boolean lethalOnPush) {
		this.lethalOnPush = lethalOnPush;
	}
	public void setLethalOnRest(boolean lethalOnRest) {
		this.lethalOnRest = lethalOnRest;
	}

	//Lethality Actions
	public void onPush(Entity entity, int v) {
		if(lethalOnPush && entity.getEntityType() == EntityType.PLAYER && !isInvincible()) {
			entity.isDead = true;
		}
	}
	public void onRest(Entity entity) {
		if(lethalOnRest && entity.getEntityType() == EntityType.PLAYER && !isInvincible()) {
			entity.isDead = true;
		}
	}
	
}
