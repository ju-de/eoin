package dmcigd.core.objects.interfaces;

import dmcigd.core.objects.*;

public interface SolidObject extends GameObject {
	
	public boolean isDestroyed();
	
	public void onPush(Entity entity, float v);
	public boolean onAttack(int damage, boolean flipped);
	
}
