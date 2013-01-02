package dmcigd.levels.lake.mobs.boss;

import dmcigd.core.objects.*;

public class BossEye extends VisibleObject {
	
	private int invincibilityCounter = 0;
	
	public BossEye(float x, float y) {
		
		setX(x);
		setY(y);
		
		setWidth(42);
		setHeight(22);
		setImageWidth(42);
		setImageHeight(24);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/lake/bosseye.gif");
	}
	
	public void setInvincibility(boolean isInvincible) {
		if(isInvincible) {
			invincibilityCounter++;
			setFrame(1 + ((invincibilityCounter / 4) % 2));
		} else {
			invincibilityCounter = 0;
			setFrame(0);
		}
	}

}
