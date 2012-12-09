package dmcigd.levels.icecave;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.objects.*;

public class IcicleTrigger extends ObjectCollision implements Region {
	
	private IcicleProjectile icicle;

	public IcicleTrigger(int x, int y, int width, int height,  IcicleProjectile icicle) {
		setX(x);
		setY(y);
		setHeight(32*height);
		setWidth(32*width);
		
		this.icicle = icicle;
	}
	
	public void step() { }

	public void onHover(Player player) { 
		icicle.fall();
	}

	public void interact(Player player) { }

}