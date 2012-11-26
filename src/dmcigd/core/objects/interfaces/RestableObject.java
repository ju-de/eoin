package dmcigd.core.objects.interfaces;

import dmcigd.core.objects.*;

public interface RestableObject extends SolidObject {
	
	public float getDX();
	public float getDY();
	
	public void onRest(Entity entity);
	public void onUnrest(Entity entity);
	
}
