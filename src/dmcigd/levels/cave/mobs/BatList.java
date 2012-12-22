package dmcigd.levels.cave.mobs;

import dmcigd.core.objects.ObjectCollision;
import dmcigd.core.objects.interfaces.Region;
import dmcigd.core.objects.player.Player;

import java.util.LinkedList;

public class BatList extends ObjectCollision implements Region {
	
	private int averageX, averageY, centerRange, outerRange;
	
	private LinkedList<Bat> bats = new LinkedList<Bat>();
	
	public BatList(int x, int y, int centerRange, int outerRange) {
		setX(x);
		setY(y);
		setWidth(0);
		setHeight(0);
		setImageWidth(0);
		setImageHeight(0);
		setImagePath("objects/cave/bat.gif");
		
		this.centerRange = centerRange;
		this.outerRange = outerRange;
	}
	
	public int getAverageX() {
		return averageX;
	}
	
	public int getAverageY() {
		return averageY;
	}
	
	public int getCenterRange() {
		return centerRange;
	}
	
	public int getOuterRange() {
		return outerRange;
	}
	
	public void setBatList(LinkedList<Bat> bats) {
		this.bats = bats;
		step();
	}
	
	public void step() {
		
		int sumX = 0, sumY = 0;
		
		for(int i = 0; i < bats.size(); i++) {
			Bat bat = bats.get(i);
			if(bat.isDestroyed) {
				bats.remove(bat);
			} else {
				sumX += bat.getX();
				sumY += bat.getY();
			}
		}
		
		averageX = sumX/bats.size();
		averageY = sumY/bats.size();
	}

	public void onHover(Player player) {}

	public void interact(Player player) {}
	
}
