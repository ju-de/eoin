package dmcigd.core.objects.interfaces;

import dmcigd.core.enums.*;

public interface RestableObject extends SolidObject {
	
	public int getDX();
	public int getDY();
	
	public void onRest(EntityType entityType);
	public void onUnrest(EntityType entityType);
	
}