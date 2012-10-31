package dmcigd.core.objects.interfaces;

import java.awt.Rectangle;

import dmcigd.core.objects.ObjectImage;

public interface Item {
	
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
	
	public void setX(int x);
	public void setY(int y);
	public void setVX(float vx);
	public void setVY(float vy);
	
	public boolean isVisible(int x, int y);
	public ObjectImage getObjectImage(int x, int y);
	
	public void setHeld(boolean held);

	public void step();
	
	public boolean isDestroyed();
	
}
