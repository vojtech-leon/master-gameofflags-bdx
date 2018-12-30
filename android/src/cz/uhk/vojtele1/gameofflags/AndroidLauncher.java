package cz.uhk.vojtele1.gameofflags;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.surfaceview.RatioResolutionStrategy;
import cz.uhk.vojtele1.gameofflags.BdxApp;

public class AndroidLauncher extends AndroidApplication {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		int width = 800;
		int height = 450;
		config.resolutionStrategy = new RatioResolutionStrategy(width, height);
		initialize(new BdxApp(), config);
	}
}
