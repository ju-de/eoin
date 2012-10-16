package dmcigd.core.interfaces;

public interface Direction {
	enum CompassDirection {
		NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
	};
	CompassDirection degreesToCompassDirection(Short degrees);
	Short compassDirectionToDegrees(CompassDirection direction);
	Double getXComponent();
	Double getYComponent();
}
