package mon.str.pokemon;

public enum PokemonTypes {

	NORMAL("Normal"),
	FIGHTING("Fighting"),
	PSYCHIC("Psychic"),
	GHOST("Ghost"),
	ELECTRIC("Electric"),
	WATER("Water"),
	FLYING("Flying"),
	GRASS("Grass"),
	BUG("Bug"),
	FIRE("Fire"),
	DRAGON("Dragon"),
	ICE("Ice"),
	FAIRY("Fairy"),
	STEEL("Steel"),
	ROCK("Rock"),
	GROUND("Ground"),
	DARK("Dark"),
	POISON("Poison");	
	
	private String type;
	
	private PokemonTypes(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
