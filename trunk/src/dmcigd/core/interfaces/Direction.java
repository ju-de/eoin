package dmcigd.core.interfaces;

public interface Direction {
	enum CompassDirections {
		NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
	};
	Short compassDirectionToDegrees(CompassDirection direction);
	CompassDirection degreesToCompassDirection(Short degrees);
	Double getXComponent();
	Double getYComponent();
}
