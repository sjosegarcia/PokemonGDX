package mon.str.life;

import mon.str.constants.Constants;
import mon.str.handlers.ExceptionHandler;
import mon.str.handlers.LifeHandler;
import mon.str.handlers.MapHandler;
import mon.str.handlers.MovementHandler.Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class PlayerRenderer extends LifeHandler {
	
	private Texture texture;
	private Stage stage;
	private MoveToAction moveAction;
	private int columns = 4, rows = 4;
	private TextureRegion[][] textureRegion;
	private TextureRegion[] frames = new TextureRegion[rows * columns];
	private TextureRegion currentFrame;
	private Animation animation;
	private String player;
	private float speed = .45f;
	private MapHandler map;
	private Rectangle bounds;
	private CollisionDetection cd;
	
	public PlayerRenderer(String player) {
		stage = new Stage();
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
	
	@Override
	public void setLifePosition(float x, float y) {
		moveAction.setPosition(x, y);
		addAction(moveAction);
	}
	
	@Override
	public Stage getStage() {
		return stage;
	}
	
	@Override
	public void setMap(MapHandler map) {
		this.map = map;
		cd = new CollisionDetection(this);
	}
	
	@Override
	public MapHandler getMap() {
		return map;
	}
	
	@Override
	public TextureRegion getLifeFrame() {
		return currentFrame;
	}
	
	@Override
	public void movement() {
		//if (!cd.canMove()) {
	//		return; // for now
	//	}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(Movement.goRight());
				moveAction.setPosition(getX()+Constants.pixel, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(Movement.goDown());
				moveAction.setPosition(getX(), getY()-Constants.pixel);
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(Movement.goLeft());
				moveAction.setPosition(getX()-Constants.pixel, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.W)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(Movement.goUp());
				moveAction.setPosition(getX(), getY()+Constants.pixel);
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		}
	}
	
	@Override
	public void dispose() {
		texture.dispose();
		stage.dispose();
	}
	
	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
	@Override
	public Texture getTexture() {
		return texture;
	}

}
