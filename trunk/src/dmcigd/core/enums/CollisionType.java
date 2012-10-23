package dmcigd.core.enums;

public enum CollisionType {
	
	SOLID(0), DESTROY(1), PLATFORM(2), LADDER(3), WATER(4), NONSOLID(5);
	
	private int priority;
	
	private CollisionType(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
