package cz.uhk.vojtele1.gameofflags;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;
import com.nilunder.bdx.Scene;

public class Player extends GameObject {

    public void main(){
        if (Bdx.keyboard.keyHit("space"))
            applyForce(0, 0, 300);
    }

    public void init() {
        Bdx.scenes.add(new Scene("HUD"));
        GameObject flag = scene.add("Flag");
        flag.position(10, 10,2);
        GameObject flag2 = scene.add("Flag");
        flag2.position(10, -10,2);
        GameObject flag3 = scene.add("Flag");
        flag3.position(-10, 10,2);
        GameObject flag4 = scene.add("Flag");
        flag4.position(-10, -10,2);
    }
}