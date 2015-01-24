package mon.str.game;

import mon.str.constants.Constants;
import mon.str.life.MapHandler;
import mon.str.life.PlayerRenderer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Main extends ApplicationAdapter {
	private MapHandler map;
	private PlayerRenderer player;
	private ShapeRenderer ren;
	
	@Override
	public void create() {
		map = new MapHandler("test2.tmx");
		player = new PlayerRenderer("Red.png");
		player.getMap(map);
		map.addMapObject(player);
		ren = new ShapeRenderer();
	}

	@Override
	public void render() {
		Gdx.graphics.setTitle(Constants.gameName + ": " + Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		map.load();
		player.getStage().draw();
		ren.begin(ShapeType.Line);
		ren.setColor(Color.BLUE);
		ren.rect(map.getBounds().getX(), map.getBounds().getY(), map.getBounds().getWidth(), map.getBounds().getHeight());
		ren.setColor(Color.RED);
		ren.rect(player.getBounds().getX(), player.getBounds().getY(), player.getBounds().width, player.getBounds().height);		
		ren.end();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		player.dispose();
	}
}