package dmcigd.core.enums;

public enum EntityType {
	//Quest Items
	QUESTITEM2(-6), QUESTITEM1(-5),
	
	//Items
	KEY4(-4), KEY3(-3), KEY2(-2), KEY1(-1),
	
	//Solid Objects
	PLAYER(0), MOVINGBLOCK(1), SOLIDBLOCK(2), DESTROYANIMATION(3),
	
	//Nonlethal Monsters
	NONLETHALMONSTER(10),
	
	//Knockback Entities
	KNOCKBACK(15),
	
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
