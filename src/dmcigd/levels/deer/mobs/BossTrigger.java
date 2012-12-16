package dmcigd.levels.deer.mobs;

import dmcigd.core.objects.ObjectCollision;
import dmcigd.core.objects.player.Player;
import dmcigd.core.objects.interfaces.Region;

public class BossTrigger extends ObjectCollision implements Region {
	
	private Boss boss;
	private boolean triggered = false;

	public BossTrigger(int x, int y, Boss boss) {
		setX(x);
		setY(y);
		setHeight(640);
		setWidth(1);
		
		setImageHeight(0);
		setImageWidth(0);
		setImagePath("objects.gif");
		
		this.boss = boss;
	}
	
	public void step() { }

	public void onHover(Player player) { 
		if(!triggered) {
			boss.triggerIntroDialogue();
			triggered = true;
		}
	}

	public void interact(Player player) { }

}
