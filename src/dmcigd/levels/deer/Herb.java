package dmcigd.levels.deer;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.Item;
import dmcigd.core.objects.items.ItemHandler;

public class Herb extends ItemHandler implements Item {
	
	public Herb(int x, int y, PhysicsHandler physicsHandler) {
		
		setX(x + 5);
		setY(y);
		setHeight(14);
		setWidth(20);
		setImageHeight(22);
		setImageWidth(30);
		
		setSequence(0);
		setFrame(0);
		
		setImagePath("objects/deer/herb.gif");


		setEntityType(EntityType.QUESTITEM1);
		setPhysicsHandler(physicsHandler);
		setGravity();
		
	}
}
