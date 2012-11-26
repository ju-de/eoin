package dmcigd.core.objects.interfaces;

public interface Item extends SolidObject {
	
	public void setX(float x);
	public void setY(float y);
	public void setVX(float vx);
	public void setVY(float vy);
	
	public void setHeld(boolean held);
	
}
