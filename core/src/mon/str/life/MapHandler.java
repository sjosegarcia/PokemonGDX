package mon.str.life;

import mon.str.handlers.AbstractHandlers;
import mon.str.handlers.ExceptionHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MapHandler extends AbstractHandlers {
	
	private TiledMapRenderer renderMap;
	private TiledMap map;
	private String name;
	private MapProperties mapProps;
	private static int tileSize = 16;
	private OrthographicCamera camera;
	private Rectangle bounds;
	private MapObjects mapObjects;
	private float x, y;
	private float width = Gdx.graphics.getWidth();
	private float height = Gdx.graphics.getHeight();
	public MapHandler(String name) {
		this.name = name;
		try {
			map = new TmxMapLoader().load(Gdx.files.internal("maps/"+ this.name).toString());
		} catch(Exception e) {
			new ExceptionHandler(this.getClass().getName(), e);
		}
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		camera.update();
		mapProps = map.getProperties();
		renderMap = new OrthogonalTiledMapRenderer(map);
		mapObjects = new MapObjects();
		bounds = new Rectangle();
	}

	public void load() {
		renderMap.setView(camera);
		renderMap.render();
		x = camera.position.x;
		y = camera.position.y;
		bounds.set(-x+(width/2), -y+(height/2), getHeight(), getHeight());
	}
	
	public static int getTileSize() {
		return tileSize;
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public TiledMapRenderer getRender() {
		return renderMap;
	}
		
	public void setMapName(String name) {
		this.name = name;
	}
	
	public String getMapName() {
		return name;
	}
	
	public int getWidth() {
		return (Integer) mapProps.get("width")*(tileSize*2);
	}

	public int getHeight() {
		return (Integer) mapProps.get("height")*(tileSize*2);
	}
		
	public void dispose() {
		((OrthogonalTiledMapRenderer) renderMap).dispose();
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public MapObjects MapObjects() {
		return mapObjects;
	}

	public void addMapObject(Actor actor) {
		mapObjects.addMapObject(actor);
	}
}
