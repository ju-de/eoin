package dmcigd.core.objects.interfaces;

import java.awt.Rectangle;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.ObjectImage;

public interface GameObject {
	
	public CollisionType getCollisionType();
	public Rectangle getBounds(int vx, int vy);
	public Rectangle getBounds();
	
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
	public ObjectImage getObjectImage(int x, int y);
	
	public void step();

}