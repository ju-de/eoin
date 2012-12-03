package dmcigd.levels.lake.mobs;

import dmcigd.core.objects.PhysicsHandler;
import dmcigd.core.objects.interfaces.RestableObject;
import dmcigd.core.objects.blocks.PushableBlock;

public class TurtleShell extends PushableBlock implements RestableObject {

	public TurtleShell(int x, int y, PhysicsHandler physicsHandler, boolean flipped) {
		super(x, y, physicsHandler);
		
		setWidth(36);
		setHeight(28);
		setImageWidth(40);
		setImageHeight(34);
		
		setSequence(2);
		setFrame(3);
		
		this.flipped = flipped;
		
		setImagePath("objects/lake/turtle.gif");
	}

}
