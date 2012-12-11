package dmcigd.levels.deer;

import dmcigd.core.enums.EntityType;
import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.Item;

public class Medicine extends Herb implements Item {

	public Medicine(int x, int y, PhysicsHandler physicsHandler) {
		super(x, y, physicsHandler);
		setX(x + 1);
		setEntityType(EntityType.QUESTITEM2);
		setImageHeight(22);
		setImageWidth(22);
		setImagePath("objects/deer/medicine.gif");
	}

}
