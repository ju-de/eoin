package dmcigd.levels.icecave;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.objects.*;

public class IcicleTrigger extends ObjectCollision implements Region {
	
	private IcicleProjectile icicle;
	private boolean triggered = false;

	public IcicleTrigger(int x, int y, int width, int height,  IcicleProjectile icicle) {
		setX(x);
		setY(y);
		setHeight(32*height);
		setWidth(32*width);
		
		setImageHeight(0);
		setImageWidth(0);
		setImagePath("objects.gif");
		
		this.icicle = icicle;
	}
	
	public void step() { }

	public void onHover(Player player) { 
		if(!triggered) {
			icicle.fall();
			triggered = true;
		}
	}

	public void interact(Player player) { }

}