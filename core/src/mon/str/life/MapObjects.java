package mon.str.life;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MapObjects {
	
	private List<Actor> actors;
	
	public MapObjects() {
		actors = new ArrayList<>();
	}

	public Collection<Actor> getMapObjects() {
		return Collections.unmodifiableList(actors);
	}
	
	public void addMapObject(Actor actor) {
		actors.add(actor);
	}
	
	public void removeActor(Actor actor) {
		actors.remove(actor);
	}
	
	public void removeActorId(int id) {
		actors.remove(id);
	}
	
	public Actor getActor(int index) {
		return actors.get(index);
	}
	
	public void removeAllMapObjects() {
		actors.clear();
	}
	
}