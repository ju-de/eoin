package dmcigd.core.objects.interfaces;

import dmcigd.core.objects.*;

public interface RestableObject extends SolidObject {
	
	public int getDX();
	public int getDY();
	
	public void onRest(Entity entity);
	public void onUnrest(Entity entity);
	
}
