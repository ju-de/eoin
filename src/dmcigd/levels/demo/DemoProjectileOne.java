package dmcigd.levels.demo;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.maps.BlockMap;
import dmcigd.core.objects.projectiles.*;

import java.util.*;

public class DemoProjectileOne extends SimpleProjectile implements SolidObject {
	
	public DemoProjectileOne(int x, int y, int speed, int angle, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {
		super(x,y,speed,angle, blockMap, solidObjects);
		
		setHeight(28);
		setWidth(28);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(8);
		
		setMapCode("`");
		setImagePath("objects.gif");
	}
	
	public void step() {
		super.step();
	}
	
}
