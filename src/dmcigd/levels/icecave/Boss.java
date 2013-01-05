package dmcigd.levels.icecave;

import dmcigd.core.enums.*;
import dmcigd.core.room.*;
import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;

public class Boss extends MovingObject implements SolidObject {
	
	private int dropClock = 10;
	private Room room;
	private boolean isDestroyed = false;
	
	public Boss(int x, int y, Room room) {

		setX(x);
		setY(y);
		setWidth(60);
		setHeight(96);
		setImageWidth(60);
		setImageHeight(100);
		
		setSequence(0);
		setFrame(0);

		setFrameLimits(new int[] {15, 2});
		setAnimationLoops(new boolean [] {false, true});
		setFrameSpeed(0.1f);
		
		this.room = room;
		room.getDialogueHandler().setDialogue(new String[][] {
				{"Wendigo", "FNORD"}
				});
		
		setCollisionType(CollisionType.NONSOLID);
		
		setImagePath("objects/icecave/boss.gif");
	}

	public void step() {
		if(getSequence() == 1) {
			addX(3.5f);
			dropClock--;
			if(dropClock <= 0) {
				room.addProjectile(new BossShard(getX() + 50, getY() + 52, (int) (Math.random() * 4), room));
				dropClock = 10;
			}
			if(getX() > 403 * 32) {
				isDestroyed = true;
			}
		} else if(getFrame() == 14) {
			room.getDialogueHandler().setDialogue(new String[][] {
					{"Wendigo", "FNARD"}
					});
			setFrameSpeed(0.03f);
			setSequence(1);
		}
		animate();
	}

	public boolean isDestroyed() { return isDestroyed; }
	
}
