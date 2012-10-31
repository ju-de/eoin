package dmcigd.core.enums;

public enum CollisionType {
	
	DESTROY(-1), SOLID(0), KILL(1), PLATFORM(2), SOLIDLADDER(3), NONSOLIDLADDER(4), WATER(5), NONSOLID(6);
	
	private int priority;
	
	private CollisionType(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
