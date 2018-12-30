package cz.uhk.vojtele1.gameofflags;

import com.nilunder.bdx.*;

public class Arrows extends GameObject {

    public static class GameState extends Component {
        private GameObject btnUp, btnDown, btnLeft, btnRight;
        private Player player;

        public GameState(GameObject g) {
            super(g);
            btnDown = g.scene.objects.get("Down");
            btnDown.components.add(new Button(btnDown));
            btnUp = g.scene.objects.get("Up");
            btnUp.components.add(new Button(btnUp));
            btnLeft = g.scene.objects.get("Left");
            btnLeft.components.add(new Button(btnLeft));
            btnRight = g.scene.objects.get("Right");
            btnRight.components.add(new Button(btnRight));
            Scene mainScene = Bdx.scenes.get("Scene");
            player = (Player) mainScene.objects.get("Player");
            state = arrows;
        }
        private State arrows = new State() {
            public void main() {
                if (Bdx.mouse.clicked(btnDown)) {
                    player.move(0,-1,0);
                }if (Bdx.mouse.clicked(btnUp)) {
                    player.move(0,1,0);
                }if (Bdx.mouse.clicked(btnLeft)) {
                    player.move(-1,0,0);
                }if (Bdx.mouse.clicked(btnRight)) {
                    player.move(1,0,0);
                }
            }
        };
    }
    public static class Button extends Component {
        public Button(GameObject g) {
            super(g);
            state = normal;
        }
        private State normal = new State() {
            public void main() {
                if (mouseOver()) {
                    g.scale(1.2f);
                    state = mouseOver;
                }
            }
        };
        private State mouseOver = new State() {
            public void main() {
                if (!mouseOver()) {
                    g.scale(1f);
                    state = normal;
                }
            }
        };
        private boolean mouseOver() {
            RayHit rh = Bdx.mouse.ray();
            return rh!= null && rh.object == g;
        }

    }

    public void init() {
        components.add(new GameState(this));
    }
    public void main() {

    }
}
