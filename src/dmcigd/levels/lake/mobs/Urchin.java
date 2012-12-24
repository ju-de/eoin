package dmcigd.levels.lake.mobs;

import dmcigd.core.objects.*;
import dmcigd.core.objects.player.*;

public class Urchin extends MovingObject {
	private boolean invincible;
	private int hp = 3,
			invincibilityClock = 0,
			objectClock = 0,
			objectClockReset;
	private Player player;
	
	public Urchin(int x, int y, int distance, Player player) {
		setX(x);
		setY(y);

		setFrameSpeed(0.015f);
		setFrameLimits(new int[] {2,2});
		setAnimationLoops(new boolean[] {true,true});
		
		objectClockReset = distance * 32;
		
		this.player = player;
	}
	
	public boolean onAttack(int damage, boolean swordflipped) {
		if(!invincible) hp--;
		invincible = true;
		return hp == 0;
	}
	
	public int getFrame() {
		
		if(invincibilityClock / 4 % 2 == 1)
			return 2;
		
		return super.getFrame();
	}
	
	public boolean isDestroyed() {
		return (hp <= 0 && invincibilityClock >= 20);
	}
	
	public void step() {
		
		if(invincible) {
			invincibilityClock++;
			if(invincibilityClock == 28) {
				setFrame(0);
				invincibilityClock = 0;
				invincible = false;
			}
		} else {
			addX(getVX());
			addY(getVY());
			
			objectClock++;
			
			if(objectClock == objectClockReset) {
				objectClock = 0;
				setVX(-getVX());
				setVY(-getVY());
			}
			
			if(getBounds().intersects(player.getBounds())) player.isDead = true;
			
			animate();
		}
	}
}
