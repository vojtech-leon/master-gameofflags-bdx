package cz.uhk.vojtele1.gameofflags.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Files;
import cz.uhk.vojtele1.gameofflags.BdxApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game of Flags";
		config.width = 800;
		config.height = 450;
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		config.vSyncEnabled = false;

		BdxApp app = new BdxApp();
		app.TICK_RATE = config.foregroundFPS;
		config.addIcon("bdx/icon_128.png", Files.FileType.Internal);
		config.addIcon("bdx/icon_32.png", Files.FileType.Internal);
		config.addIcon("bdx/icon_16.png", Files.FileType.Internal);
		new LwjglApplication(app, config);
	}
}
