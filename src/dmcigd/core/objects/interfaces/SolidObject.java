package dmcigd.core.objects.interfaces;

import dmcigd.core.enums.CollisionType;

public interface SolidObject {
	
	public boolean isRestable = false;
	
	public CollisionType isSolid();
	public String getMapCode();
	public String getImagePath();
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public boolean isVisible(int x, int y);
	public void step();
}
