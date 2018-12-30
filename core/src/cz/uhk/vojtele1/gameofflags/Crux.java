package cz.uhk.vojtele1.gameofflags;

import com.nilunder.bdx.*;

import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;

public class Crux extends GameObject{

    private float ox, oy;
    private Vector2f pos, f1Pos, f2Pos, f1PosNew, f2PosNew, f1DiffPos, f2DiffPos;
    private Vector3f pos3;
    private static final float uhel = (float)(2 * Math.PI)/360;

    private float distance = 0, distance2 = 0, diff = 0;

    public void main() {
        if (Bdx.mouse.wheelMove() != 0) {
            System.out.println(Bdx.mouse.wheelMove());
            children.get("Camera").move(0,0,Bdx.mouse.wheelMove());
        }
        if (Bdx.fingers.size() == 1) {
            if (Bdx.mouse.btnHit("left")) {
                // pos = Bdx.mouse.position();
                pos3 = Bdx.mouse.rayDirection();
                ox = pos3.x;
                oy = pos3.y;
            }
            if (Bdx.mouse.btnDown("left")) {
                // move((pos.x - ox) / 5, (pos.y - oy) / 5, 0);
                Vector3f vektor = new Vector3f(ox - pos3.x, oy - pos3.y, 0);
                ox = pos3.x;
                oy = pos3.y;
                //pos = Bdx.mouse.position();
                pos3 = Bdx.mouse.rayDirection();
                move(vektor.mul(100));
            }

            if (Bdx.mouse.btnHit("middle")) {
                pos = Bdx.mouse.position();
                ox = pos.x;
                oy = pos.y;
            }
            if (Bdx.mouse.btnDown("middle")) {
                rotate(0, 0, uhel * (ox - pos.x));
                ox = pos.x;
                oy = pos.y;
                pos = Bdx.mouse.position();
            }
        }
        if (Bdx.fingers.size() > 1) {
            if (Bdx.fingers.get(1).hit()) {
                f1Pos = Bdx.fingers.get(0).position();
                f2Pos = Bdx.fingers.get(1).position();
                f1PosNew = f1Pos;
                f2PosNew = f2Pos;
                distance = (float) Math.sqrt(Math.pow(f2Pos.x - f1Pos.x, 2) + Math.pow(f2Pos.y - f1Pos.y, 2));
            }
            if (Bdx.fingers.get(0).down() && Bdx.fingers.get(1).down()) {
                f1Pos = Bdx.fingers.get(0).position();
                f2Pos = Bdx.fingers.get(1).position();
                distance2 = (float) Math.sqrt(Math.pow(f2Pos.x - f1Pos.x, 2) + Math.pow(f2Pos.y - f1Pos.y, 2));
                diff = distance - distance2;
                f1DiffPos = f1Pos.minus(f1PosNew);
                f2DiffPos = f2Pos.minus(f2PosNew);
                if (Math.abs(diff) > 10) {
                    scene.camera.move(0,0, diff/10);
                } else {
                    if (f1DiffPos.x * f2DiffPos.x > 0) {
                        rotate(0, 0, uhel * ((f1DiffPos.x + f2DiffPos.x) / 2));
                    }
                }
                distance = distance2;
                f1PosNew = f1Pos;
                f2PosNew = f2Pos;
            }
        }
        if (scene.camera.position().z < 30) {
            scene.camera.position(scene.camera.position().x,scene.camera.position().y,30);
        }
        if (scene.camera.position().z > 80) {
            scene.camera.position(scene.camera.position().x,scene.camera.position().y,80);
        }
    }

    public void init() {
        scene.camera.far(300);
        // TODO chci mlhu?
        scene.fogRange(50, 100);
        scene.fog(true);
    }
}