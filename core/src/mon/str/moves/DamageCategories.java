package mon.str.moves;

public enum DamageCategories {

	UNKNOWN(-1),
	PHYSICAL(0),
	SPECIAL(1),
	STATUS(2);
	
	private int category;
	
	private DamageCategories(int category) {
		this.category = category;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getCategoryId(int category) {
		for (DamageCategories dc : DamageCategories.values()) {
			if (dc.getCategory() == category) {
				return category;
			}
		}
		return UNKNOWN.getCategory();
	}
	
}
