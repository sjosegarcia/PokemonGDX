package mon.str.life;

import mon.str.constants.Constants;
import mon.str.handlers.ExceptionHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class PlayerRenderer extends Actor {
	
	private Texture texture;
	private Stage stage;
	private MoveToAction moveAction;
	private int columns = 4, rows = 4;
	private TextureRegion[][] textureRegion;
	private TextureRegion[] frames = new TextureRegion[rows * columns];
	private TextureRegion currentFrame;
	private Animation animation;
	private String player;
	private float speed = .50f;
	private MapHandler map;
	private Rectangle bounds;
	private CollisionDetection cd;
	
	public PlayerRenderer(String player) {
		stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		this.player = player;
		Gdx.input.setInputProcessor(stage);
		try {
			texture = new Texture(Gdx.files.internal("players/"+ this.player).toString());
		} catch(Exception e) {
			new ExceptionHandler(this.getClass().getName(), e);
		}
		textureRegion = TextureRegion.split(texture, texture.getWidth()/columns, texture.getHeight()/rows);
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				frames[index++] = textureRegion[i][j];
			}
		}
		animation = new Animation(1, frames);
		currentFrame = animation.getKeyFrame(0);
		moveAction = new MoveToAction();
		stage.addActor(this);
		bounds = new Rectangle();
	}
		
	public void draw(Batch batch, float alpha) {
		stage.act(Gdx.graphics.getDeltaTime());
		movement();
		map.getCamera().position.set(getX(), getY(), 0);
		map.getCamera().update();
		batch.setProjectionMatrix(map.getCamera().combined);
		batch.draw(currentFrame, getX(), getY());
	}
	
	public void setPlayerPosition(float x, float y) {
		moveAction.setPosition(x, y);
		addAction(moveAction);
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setMap(MapHandler map) {
		this.map = map;
		cd = new CollisionDetection(this);
	}
	
	public MapHandler getMap() {
		return map;
	}
	
	public TextureRegion getPlayerFrame() {
		return currentFrame;
	}
	
	public void movement() {
		//if (!cd.canMove()) {
	//		return; // for now
	//	}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goRight());
				moveAction.setPosition(getX()+Constants.pixel, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goDown());
				moveAction.setPosition(getX(), getY()-Constants.pixel);
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goLeft());
				moveAction.setPosition(getX()-Constants.pixel, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.W)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goUp());
				moveAction.setPosition(getX(), getY()+Constants.pixel);
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		}
	}
		
	public void dispose() {
		texture.dispose();
		stage.dispose();
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	public Texture getTexture() {
		return texture;
	}

}
