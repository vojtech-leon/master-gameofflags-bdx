package cz.uhk.vojtele1.gameofflags.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import cz.uhk.vojtele1.gameofflags.*;
public class iScene extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Flag"))
			return new cz.uhk.vojtele1.gameofflags.Flag();
		if (gobj.get("class").asString().equals("Player"))
			return new cz.uhk.vojtele1.gameofflags.Player();
		if (gobj.get("class").asString().equals("Crux"))
			return new cz.uhk.vojtele1.gameofflags.Crux();

		return super.newObject(gobj);
	}
	
}
