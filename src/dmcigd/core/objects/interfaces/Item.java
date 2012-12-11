package dmcigd.core.objects.interfaces;

import dmcigd.core.enums.EntityType;

public interface Item extends SolidObject {
	
	public void setX(float x);
	public void setY(float y);
	public void setVX(float vx);
	public void setVY(float vy);
	
	public void setHeld(boolean held);
	
	public EntityType getEntityType();
	
}
