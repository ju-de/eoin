package dmcigd.core.interfaces;

public interface Vector {
	Magnitude getMagnitude();
	Boolean setMagnitude(Magnitude magnitude);
	Direction getDirection();
	Boolean setDirection(Direction direction);
	Vector addVector(Vector vector);
	Vector subtractVector(Vector vector);
}
