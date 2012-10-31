package dmcigd.core.objects.interfaces;

import dmcigd.core.enums.*;
import dmcigd.core.objects.*;

import java.awt.*;

public interface SolidObject {
	
	public CollisionType getCollisionType();
	public Rectangle getBounds(int vx, int vy);
	public Rectangle getBounds();
	
	public String getMapCode();
	public String getImagePath();
	
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public int getImageWidth();
	public int getImageHeight();
	public int getSequence();
	public int getFrame();
	
	public boolean isVisible(int x, int y);
	public boolean isDestroyed();
	public ObjectImage getObjectImage(int x, int y);
	
	public void onPush(Entity entity, int v);
	public void step();
}
