package mon.str.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import mon.str.constants.Constants;
import mon.str.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = Constants.fullscreen;
		config.resizable = Constants.resizable;
		config.width = Constants.width;
		config.height = Constants.height;
		new LwjglApplication(new Main(), config);
	}
}