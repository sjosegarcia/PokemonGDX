package mon.str.game;

import mon.str.constants.Constants;
import mon.str.handlers.MapHandler;
import mon.str.life.PlayerRenderer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Main extends ApplicationAdapter {
	private MapHandler map;
	private PlayerRenderer player;
	
	@Override
	public void create() {
		map = new MapHandler("test2.tmx");
		player = new PlayerRenderer("red.png");
		player.setMap(map);
		map.addMapObject(player);
	}

	@Override
	public void render() {
		Gdx.graphics.setTitle(Constants.gameName + " FPS: " + Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		map.update();
		player.getStage().draw();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		player.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		map.getViewport().update(width, height);
	}
}