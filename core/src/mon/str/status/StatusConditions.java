package mon.str.status;

public enum StatusConditions {
	UNKNOWN(-1),
	NORMAL(0),
	BURN(1),
	POISON(2),
	PARALYSIS(3),
	FREEZE(4);
	
	private int status;
	
	private StatusConditions(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	public int getStatusId(int status) {
		for(StatusConditions s : StatusConditions.values()) {
			if (s.getStatus() == status) {
				return status;
			}
		}
		return UNKNOWN.getStatus();
	}
	
}
