package cz.uhk.vojtele1.gameofflags;

import com.badlogic.gdx.utils.Timer;
import com.nilunder.bdx.*;

import javax.vecmath.Vector3f;

public class CenterPlayer extends GameObject {
    private Scene mainScene;
    private Crux crux;
    public void init() {
        components.add(new Arrows.Button(this));
        mainScene = Bdx.scenes.get("Scene");
        crux = (Crux) mainScene.objects.get("Crux");
    }
    public void main() {
        center();
    }
    private void center() {
        if (Bdx.mouse.clicked(this)) {
            final int repeat = 50;
            final float cameraDiffZ = 30 - mainScene.camera.position().z;
            final Vector3f targetPosition = mainScene.objects.get("Player").position().minus(mainScene.objects.get("Player").axis(1).mul(4));  // The target position is the player's position minus 4 X the player's front axis
            Timer.schedule(new Timer.Task(){
                    @Override
                    public void run() {
                        Vector3f diff = targetPosition.minus(crux.position()).mul(0.1f);  // 0.1 is how much of a percentage of the difference between the target position and the camera's actual position to move
                        crux.move(diff);
                        mainScene.camera.move(0,0,cameraDiffZ / repeat);
                    }
                }, 0,0.01f, repeat);
        }
    }
}
