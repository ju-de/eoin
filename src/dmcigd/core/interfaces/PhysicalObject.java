package dmcigd.core.interfaces;

public interface PhysicalObject {
	Integer getX();
	Boolean setX(Integer x);
	Integer getY();
	Boolean setY(Integer y);
	Integer addX(Integer x);
	Integer addY(Integer y);
	Boolean solid(Boolean solid);
	Boolean isSolid();
	Boolean visible(Boolean visible);
	Boolean isVisible();
	Boolean addMotionVector(Vector motion);
	Boolean removeMotionVector(Vector motion);
	Vector getMotionVectors();
	Boolean addAccelerationVector(Vector acceleration);
	Boolean removeAccelerationVector(Vector Acceleration);
	Vector getAccelerationVectors();
	Boolean collidesWith(PhysicalObject other);
}
