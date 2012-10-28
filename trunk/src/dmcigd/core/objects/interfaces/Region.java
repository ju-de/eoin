package dmcigd.core.objects.interfaces;

import java.awt.Rectangle;

import dmcigd.core.objects.ObjectImage;
import dmcigd.core.objects.player.*;

public interface Region {
	
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
	public ObjectImage getObjectImage(int x, int y);

	public void onHover();
	public void interact(Player player);
	public void step();
}
