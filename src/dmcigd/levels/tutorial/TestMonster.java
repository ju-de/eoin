package dmcigd.levels.tutorial;

import dmcigd.core.enums.*;
import dmcigd.core.objects.maps.*;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.monsters.*;

import java.util.*;

public class TestMonster extends LethalityHandler implements RestableObject {
	
	public TestMonster(int x, int y, BlockMap blockMap, ArrayList<SolidObject> solidObjects) {

		setX(x);
		setY(y);
		setDX(0);
		setDY(0);
		setHeight(28);
		setWidth(24);
		setImageHeight(32);
		setImageWidth(32);
		
		setSequence(4);
		setFrame(8);
		
		setImagePath("objects.gif");
		
		setCollisionType(CollisionType.SOLID);
		
		setBlockMap(blockMap);
		setSolidObjects(solidObjects);
		setEntityType(EntityType.NONLETHALMONSTER);
		setGravity();
		
		setMaxHitpoints(40);
		
		setLethalOnPush(true);
		
		setKnockback(true);
		
	}
	
	public void step() {
		
		super.step();
		
		if(isFlickering()) {
			setSequence(0);
		}else{
			setSequence(4);
			setFrame(8);
		}
		
		move();
		
	}
	
	public void onRest(EntityType entityType) {}

	public void onUnrest(EntityType entityType) {}
	
}
