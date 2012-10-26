package dmcigd.core.enums;

public enum EntityType {
	
	PLAYER(0), MOVINGBLOCK(1), MONSTER(2);
	
	private int code;
	
	private EntityType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
}
