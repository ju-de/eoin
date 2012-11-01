package dmcigd.core.objects.interfaces;

public interface Item extends SolidObject {
	
	public void setX(int x);
	public void setY(int y);
	public void setVX(float vx);
	public void setVY(float vy);
	
	public void setHeld(boolean held);
	
}
