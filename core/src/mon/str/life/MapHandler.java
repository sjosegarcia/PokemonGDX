package mon.str.life;

import mon.str.handlers.AbstractHandlers;
import mon.str.handlers.ExceptionHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapHandler extends AbstractHandlers {
	
	private TiledMapRenderer renderMap;
	private TiledMap map;
	private String name;
	private MapProperties mapProps;
	private boolean[][] grid;
	private static int tileSize = 16;
	private OrthographicCamera camera;
	
	public MapHandler(String name) {
		this.name = name;
		try {
			map = new TmxMapLoader().load(Gdx.files.internal("maps/"+ this.name).toString());
		} catch(Exception e) {
			new ExceptionHandler(this.getClass().getName(), e);
		}
		mapProps = map.getProperties();
		renderMap = new OrthogonalTiledMapRenderer(map);
		grid = new boolean[getWidth()/tileSize][getHeight()/tileSize];
	}

	public void load() {
		renderMap.setView(camera);
		renderMap.render();
	}
	
	public void setCamera(Camera camera) {
		this.camera = (OrthographicCamera) camera;
		this.camera.setToOrtho(false);
		this.camera.update();
		
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
		
	public boolean[][] getGrid() {
		return grid;
	}
		
	public void setMapName(String name) {
		this.name = name;
	}
	
	public String getMapName() {
		return name;
	}
	
	public int getWidth() {
		return (Integer) mapProps.get("width");
	}

	public int getHeight() {
		return (Integer) mapProps.get("height");
	}
		
	public void dispose() {
		((OrthogonalTiledMapRenderer) renderMap).dispose();
	}
}
