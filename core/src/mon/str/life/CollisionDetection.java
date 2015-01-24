package mon.str.life;

public class CollisionDetection {
	
	private MapHandler map;
	private PlayerRenderer player;
		
	public CollisionDetection(MapHandler map, PlayerRenderer player) {
		this.map = map;
		this.player = player;
	}
	
	public boolean canMove() {
		if (player.getBounds().overlaps(map.getBounds())) {
			return false;
		}
		return true;
	}
	
	
}
