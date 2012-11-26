package dmcigd.levels.demo;

import dmcigd.core.objects.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.player.Player;

import java.util.*;

public class DemoProjectileSpawner extends ObjectCollision implements Region {

	int objectClock,clockReset,angleClock;
	private ArrayList<SolidObject> projectiles,solidObjects;
	private BlockMap blockMap;
	
	public DemoProjectileSpawner (int x, int y, ArrayList<SolidObject> projectiles, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		
		setX(x + 6);
		setY(y);
		setHeight(30);
		setWidth(20);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(9);
		
		setImagePath("objects.gif");
		
		this.projectiles = projectiles;
		this.blockMap = blockMap;
		this.solidObjects = solidObjects;
		objectClock = 0;
		angleClock = 0;
		clockReset = 50;
		
	}
	
	public void onHover(Player player) {}

	public void interact(Player player) { }
	
	public void step() {
		
		objectClock++;
		
		if(objectClock == clockReset) {
			angleClock++;
			if(angleClock == 8) {
				angleClock = 0;
			}
			objectClock = 0;
			projectiles.add(new DemoProjectileOne((int) getX(),(int) getY(),3,angleClock * 45,blockMap,solidObjects));
		}
		
	}
}
