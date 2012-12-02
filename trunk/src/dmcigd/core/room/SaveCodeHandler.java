package dmcigd.core.room;

import java.util.*;
import java.util.Map.Entry;

public class SaveCodeHandler {
	
	public static int digitValue(char inputChar) {
		if(inputChar == 'R') {
			return 3;
		}else if(inputChar == 'Y') {
			return 2;
		}else if(inputChar == 'G') {
			return 1;
		} else {
			return 0;
		}
	}

	@SuppressWarnings("serial")
	public static final Map<String, String> levelCodes = new HashMap<String, String>() {{
		//Right now everything uses a simple base 4 system
		//R = 3; Y = 2; G = 1; B = 0
		//The first two digits are the level, the second two are the room
		//I.e. RY 	= 3 * 4 + 2 * 1
		//			= 12 + 2
		//			= 14
		//Levels 0 and 1 are the system and tutorial levels respectively
		//System levels		BB
		put("BBBB","game.MainMenu");
		//Tutorial			BG
		put("BGBB","tutorial.Tutorial");
		//Rabbit hills		BY
		put("BYBB","rabbit.One");
		put("BYBG","rabbit.Two");
		put("BYBY","rabbit.Three");
		put("BYBR","rabbit.BossRoom");
		//Ogre camp			BR
		put("BRBB","ogre.One");
		//Deer village		GB
		put("GBBB","deer.One");
		put("GBBG","deer.Two");
		//Cave				GG
		put("GGBB","cave.Cave1");
		//Ice rift			GY
		put("GYBB","icecave.IceRoom1");
		put("GYBG","icecave.IceRoom2"); 
		//Lake				GR
		put("GRBB","lake.One");
		put("GRBG","lake.Two");
		put("GRBY","lake.Three");
		put("GRGB","lake.Bonus");
		//Faerie forest		YB
		put("YBBB","faerie.One");
		put("YBBG","faerie.Two");
		put("YBBY","faerie.Three");
		put("YBGB","faerie.Boss");
		//Swamp				YG
		put("YGBB","swamp.One");
		put("YGBG","swamp.Two");
		put("YGBY","swamp.Three");
	}};
	
	public static String getLevelCode(String levelName) {
		
		Iterator<Entry<String, String>> it = levelCodes.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, String> pairs = (Entry<String, String>)it.next();
	        if(levelName.equals(pairs.getValue().toString())) {
	        	return pairs.getKey();
	        }
	    }
	    
	    //Default return code
	    return "BBBB";
	}
	
	public static int killCount(String inputString) {
		return digitValue(inputString.charAt(0)) * 256
				+ digitValue(inputString.charAt(1)) * 64
				+ digitValue(inputString.charAt(2)) * 16
				+ digitValue(inputString.charAt(3)) * 4
				+ digitValue(inputString.charAt(4));
	}
	
}
