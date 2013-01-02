package dmcigd.levels.lake.mobs.boss;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;
import dmcigd.core.objects.regions.*;

public class BonusWarp extends RoomWarp implements Region{

	public boolean triggered = false;
	
	public BonusWarp(int x, int y, int width, int height, String destRoom) {
		super(x, y, width, height, destRoom);
	}
	
	public void onHover(Player player) {
		
		if(!triggered) super.onHover(player);
		
	}
	
}
