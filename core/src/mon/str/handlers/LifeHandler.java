package mon.str.handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class LifeHandler extends Actor {
	
	public void draw(Batch batch, float alpha) {}
	
	public void setLifePosition(float x, float y) {}
	
	public Stage getStage() {
		return null;
	}
	
	public void setMap(MapHandler map) {}
	
	public MapHandler getMap() {
		return null;
	}
	
	public TextureRegion getLifeFrame() {
		return null;
	}
	
	public boolean movement() {
		return false;
	}
	
	public void dispose() {}
	
	public Rectangle getBounds() {
		return null;
	}
	
	public Texture getTexture() {
		return null;
	}	
	
	public boolean isFacingDown() {
		return false;
	}
	
	public boolean isFacingLeft() {
		return false;
	}
	
	public boolean isFacingRight() {
		return false;
	}
	
	public boolean isFacingUp() {
		return false;
	}
	
	public boolean translatedX() {
		return false;
	}
	
	public boolean translatedY() {
		return false;
	}
	
	public boolean isIdleFrame() {
		return false;
	}
	
	public boolean hasTranslated() {
		return translatedX() || translatedY();
	}
	
	public boolean translatingX() {
		return false;
	}
	
	public boolean isTranslating() {
		return false;
	}
	
	public boolean translatingY() {
		return false;
	}
	
	public void setMoveAnimation(int moveAnimation) {}
	
	public int getMoveAnimation() {
		return 0;
	}
}