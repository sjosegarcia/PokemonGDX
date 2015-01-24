package mon.str.life;

import mon.str.handlers.ExceptionHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

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
	private int tileSize = MapHandler.getTileSize();
	private MapHandler map;
	
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
		moveAction.setPosition(Gdx.graphics.getWidth()/2-MapHandler.getTileSize(), Gdx.graphics.getHeight()/2-MapHandler.getTileSize());
		addAction(moveAction);
		stage.addActor(this);
	}
		
	public void draw(Batch batch, float alpha) {
		stage.act(Gdx.graphics.getDeltaTime());
		movement();
		map.getCamera().position.set(getX()+tileSize, getY()+tileSize, 0);
		batch.draw(currentFrame, getX(), getY());
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void getMap(MapHandler map) {
		this.map = map;
	}
	
	public void movement() { // move this to movement handler
		if (Gdx.input.isKeyPressed(Keys.D)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goRight());
				moveAction.setPosition(getX()+tileSize*2, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);
			}
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goDown());
				moveAction.setPosition(getX(), getY()-tileSize*2);
				moveAction.setDuration(speed);
				addAction(moveAction);	
			}
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goLeft());
				moveAction.setPosition(getX()-tileSize*2, getY());
				moveAction.setDuration(speed);
				addAction(moveAction);	
			}
		} else if (Gdx.input.isKeyPressed(Keys.W)) {
			if (!getActions().contains(moveAction, true)) {
				moveAction.reset();
				currentFrame = animation.getKeyFrame(MovementHandler.goUp());
				moveAction.setPosition(getX(), getY()+tileSize*2);
				moveAction.setDuration(speed);
				addAction(moveAction);	
			}
		}
	}
	
	public void dispose() {
		stage.dispose();
	}
}
