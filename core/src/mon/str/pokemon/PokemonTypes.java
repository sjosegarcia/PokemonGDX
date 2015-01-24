package mon.str.pokemon;

public enum PokemonTypes {

	UNKOWN(-1),
	NORMAl(0),
	FIGHTING(1),
	PSYCHIC(2),
	GHOST(3),
	ELECTRIC(4),
	WATER(5),
	FLYING(6),
	GRASS(7),
	BUG(8),
	FIRE(9),
	DRAGON(10),
	ICE(11),
	FAIRY(12),
	STEEL(13),
	ROCK(14),
	GROUND(15),
	DARK(16),
	POISON(17);
	
	private int type;
	
	private PokemonTypes(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public int getTypeId(int type) {
		for (PokemonTypes pt : PokemonTypes.values()) {
			if (pt.getType() == type) {
				return type;
			}
		}
		return UNKOWN.getType();
	}
	
}
