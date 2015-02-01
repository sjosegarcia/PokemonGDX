package mon.str.handlers;

public enum MovementHandler {

	DOWN(0),
	LEFT(4),
	RIGHT(8),
	UP(12);
	
	private int direction;
	
	private MovementHandler(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public class Movement {
		
		private int direction;
		
		public Movement(){
			this.direction = 0;
		}
		
		public Movement(int direction) {
			this.direction = direction;
		}
		
		public void setDirection(int direction) {
			this.direction = direction;
		}
		
		public int getDirection() {
			return direction;
		}
		
		public boolean isFacingDown(int direction) {
			return direction == goDown();
		}
		
		public boolean isFacingLeft(int direction) {
			return direction == goLeft();
		}
		
		public boolean isFacingRight(int direction) {
			return direction == goRight();
		}
		
		public boolean isFacingUp(int direction) {
			return direction == goUp();
		}
		
		public int goDown() {
			return MovementHandler.DOWN.getDirection();
		}
		
		public int goLeft() {
			return MovementHandler.LEFT.getDirection();
		}
		
		public int goRight() {
			return MovementHandler.RIGHT.getDirection();
		}
		
		public int goUp() {
			return MovementHandler.UP.getDirection();
		}
		
	}
	
}
