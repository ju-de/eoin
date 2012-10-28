package dmcigd.core.enums;

public enum EntityType {
	
	//Items
	KEY4(-4), KEY3(-3), KEY2 (-2), KEY1(-1),
	//Other entities
	PLAYER(0), MOVINGBLOCK(1), MONSTER(2);
	
	private int code;
	
	private EntityType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
}
