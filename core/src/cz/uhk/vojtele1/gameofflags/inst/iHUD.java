package cz.uhk.vojtele1.gameofflags.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import cz.uhk.vojtele1.gameofflags.*;
public class iHUD extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Arrows"))
			return new cz.uhk.vojtele1.gameofflags.Arrows();
		if (gobj.get("class").asString().equals("CenterPlayer"))
			return new cz.uhk.vojtele1.gameofflags.CenterPlayer();

		return super.newObject(gobj);
	}
	
}
