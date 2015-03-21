package mon.str.life;

import java.awt.Point;

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
	private float speed = .40f;
	private MapHandler map;
	private Rectangle bounds;
	private CollisionDetection cd;
	private int moveAnimation;
	private int currentDirection;
	private Point targetPosition = new Point();
	private boolean isX = false;
	private boolean isY = false;
	
	public PlayerRenderer(String player) {
		stage = new Stage();
		this.player = player;
		Gdx.input.setInputProcessor(stage);
		try {
			texture = new Texture(Gdx.files.internal("players/" + this.player).toString());
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
		currentFrame = animation.getKeyFrame(0, true);
		moveAction = new MoveToAction();
		stage.addActor(this);
		bounds = new Rectangle();
		targetPosition.setLocation(getX(), getY());
	}
		
	public void draw(Batch batch, float alpha) {//TODO remove the possibility of moving on the idle frames (frame 0 and 2), it happens if the player is holding down the button
		stage.act(Gdx.graphics.getDeltaTime());
		if (movement()) {
			moveAnimation++;
		}
		if (isTranslating()) {
			if (moveAnimation % 2 == 1) {
				moveAnimation++;
			}
			isY = false;
			isX = false;
		}
		if (moveAnimation < 0 || moveAnimation > 3) {
			moveAnimation = 0;
		}
		map.getCamera().position.set(getX(), getY(), 0);
		map.getCamera().update();
		batch.setProjectionMatrix(map.getCamera().combined);
		currentFrame = animation.getKeyFrame(currentDirection + moveAnimation, true);
		batch.draw(currentFrame, getX(), getY());
	}
	
	@Override
	public void setLifePosition(float x, float y) {
		moveAction.setPosition(x, y);
		addAction(moveAction);
		moveAction.reset();
	}
	
	@Override
	public boolean translateX() {
		return isX && (targetPosition.x == getX());
	}
	
	@Override
	public boolean translateY() {
		return isY && (targetPosition.y == getY());
	}
	
	@Override
	public boolean isIdleFrame() {
		return moveAnimation % 2 == 0;
	}
	
	@Override
	public boolean isTranslating() {
		return translateX() || translateY();
	}
	
	@Override
	public void setMoveAnimation(int moveAnimation) {
		this.moveAnimation = moveAnimation;
	}
	
	@Override
	public int getMoveAnimation() {
		return moveAnimation;
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
	public boolean movement() {
		//if (!cd.canMove()) {
		//	return true; // for now
		//}
		int xOffset = 0;
		int yOffset = 0;
		int[] keyArray = {Keys.W, Keys.A, Keys.S, Keys.D};
		for (int i = 0; i < keyArray.length; i++) {
			if (Gdx.input.isKeyPressed(keyArray[i])) {
				if (!getActions().contains(moveAction, true)) {
					moveAction.reset();
					switch (keyArray[i]) {
						case Keys.W:
							currentDirection = Movement.goUp();
							yOffset += Constants.pixel;
							isY = true;
							break;
						case Keys.A:
							currentDirection = Movement.goLeft();
							xOffset -= Constants.pixel;
							isX = true;
							break;
						case Keys.S:
							currentDirection = Movement.goDown();
							yOffset -= Constants.pixel;
							isY = true;
							break;
						case Keys.D:
							currentDirection = Movement.goRight();
							xOffset += Constants.pixel;
							isX = true;
							break;
					}
					targetPosition.setLocation(getX() + xOffset, getY() + yOffset);
					moveAction.setPosition(getX() + xOffset, getY() + yOffset);
					moveAction.setDuration(speed);
					addAction(moveAction);
				return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isFacingDown() {
		return currentDirection == Movement.goDown();
	}
	
	@Override
	public boolean isFacingLeft() {
		return currentDirection == Movement.goLeft();
	}
	
	@Override
	public boolean isFacingRight() {
		return currentDirection == Movement.goRight();
	}
	
	@Override
	public boolean isFacingUp() {
		return currentDirection == Movement.goUp();
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
