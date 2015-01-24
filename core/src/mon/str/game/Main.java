package mon.str.game;

import mon.str.life.MapHandler;
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
		player = new PlayerRenderer("Red.png");
		map.setCamera(player.getStage().getCamera());
		player.getMap(map);
	}

	@Override	
	public void render() {
		Gdx.graphics.setTitle("Game FPS: " + Gdx.graphics.getFramesPerSecond());	
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		map.load();
		player.getStage().draw();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		player.dispose();
	}
}