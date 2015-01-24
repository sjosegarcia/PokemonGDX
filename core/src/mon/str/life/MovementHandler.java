package mon.str.life;

public enum MovementHandler {

	DOWN(0),
	LEFT(4),
	RIGHT(8),
	UP(12);
	
	private int direction;
	
	MovementHandler(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public static int goDown(){
		return 0;
	}
	
	public static int goLeft(){
		return 4;
	}
	
	public static int goRight(){
		return 8;
	}	
	
	public static int goUp(){
		return 12;
	} 
		
	public boolean isFacingUp() {
		return direction == 12;
	}
	
}
