package dmcigd.core.enums;

public enum EntityType {
	
	//Items
	KEY4(-4), KEY3(-3), KEY2(-2), KEY1(-1),
	
	//Solid Objects
	PLAYER(0), MOVINGBLOCK(1),
	
	//Nonlethal Monsters
	NONLETHALMONSTER(10),
	
	//Lethal Monsters
	LETHALMONSTER(20),
	
	//Projectiles
	PROJECTILE(30);
	
	private int code;
	
	private EntityType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
}
