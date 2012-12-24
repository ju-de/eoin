package dmcigd.levels.lake.mobs;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.player.Player;

public class VerticalUrchin extends Urchin implements SolidObject {

	public VerticalUrchin(int x, int y, int distance, boolean flipped, Player player) {
		super(x, y, distance, player);
		
		setWidth(16);
		setHeight(28);
		setImageWidth(20);
		setImageHeight(32);
		
		setImagePath("objects/lake/verticalurchin.gif");
		
		if(flipped) {
			setVY(-1);
			this.flipped = true;
			addX(16);
		} else {
			setVY(1);
		}
	}

}
