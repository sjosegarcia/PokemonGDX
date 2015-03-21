package mon.str.pokemon;

public enum PokemonTypeManipulator {//TODO Add Curse or the ???-type
	
	NORMAl(new PokemonTypes[] {PokemonTypes.FIGHTING}, new PokemonTypes[] {PokemonTypes.GHOST}),
	FIGHTING(new PokemonTypes[]{PokemonTypes.FLYING, PokemonTypes.PSYCHIC}, new PokemonTypes[]{PokemonTypes.ROCK, PokemonTypes.BUG,PokemonTypes.DARK}),
	PSYCHIC(new PokemonTypes[] {PokemonTypes.BUG, PokemonTypes.GHOST, PokemonTypes.DARK}, new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.PSYCHIC}),
	GHOST(new PokemonTypes[]{PokemonTypes.GHOST, PokemonTypes.DARK}, new PokemonTypes[]{PokemonTypes.POISON, PokemonTypes.BUG}, new PokemonTypes[]{PokemonTypes.NORMAL, PokemonTypes.FIGHTING}),
	ELECTRIC(new PokemonTypes[] {PokemonTypes.GROUND}, new PokemonTypes[] {PokemonTypes.FLYING, PokemonTypes.STEEL, PokemonTypes.ELECTRIC}),
	WATER(new PokemonTypes[]{PokemonTypes.ELECTRIC, PokemonTypes.GRASS}, new PokemonTypes[]{PokemonTypes.STEEL, PokemonTypes.STEEL, PokemonTypes.FIRE, PokemonTypes.WATER, PokemonTypes.ICE}),
	FLYING(new PokemonTypes[]{PokemonTypes.ROCK, PokemonTypes.ELECTRIC, PokemonTypes.ICE}, new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.BUG, PokemonTypes.GRASS}, new PokemonTypes[]{PokemonTypes.GROUND}),
	GRASS(new PokemonTypes[]{PokemonTypes.FLYING, PokemonTypes.POISON, PokemonTypes.BUG, PokemonTypes.FIRE, PokemonTypes.ICE}, new PokemonTypes[]{PokemonTypes.GROUND, PokemonTypes.WATER, PokemonTypes.GRASS, PokemonTypes.ELECTRIC}),
	BUG(new PokemonTypes[]{PokemonTypes.FLYING, PokemonTypes.ROCK, PokemonTypes.FIRE}, new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.GROUND, PokemonTypes.GRASS}),
	FIRE(new PokemonTypes[]{PokemonTypes.GROUND, PokemonTypes.ROCK, PokemonTypes.WATER}, new PokemonTypes[]{PokemonTypes.BUG, PokemonTypes.STEEL, PokemonTypes.FIRE, PokemonTypes.GRASS, PokemonTypes.ICE, PokemonTypes.FAIRY}),
	DRAGON(new PokemonTypes[]{PokemonTypes.ICE, PokemonTypes.DRAGON, PokemonTypes.FAIRY}, new PokemonTypes[]{PokemonTypes.FIRE, PokemonTypes.WATER, PokemonTypes.ELECTRIC, PokemonTypes.GRASS}),
	ICE(new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.ROCK, PokemonTypes.STEEL, PokemonTypes.FIRE}, new PokemonTypes[]{PokemonTypes.ICE}),
	FAIRY(new PokemonTypes[]{PokemonTypes.POISON, PokemonTypes.STEEL},new PokemonTypes[]{PokemonTypes.BUG, PokemonTypes.DARK, PokemonTypes.FIGHTING}, new PokemonTypes[]{PokemonTypes.DRAGON}),
	STEEL(new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.GROUND, PokemonTypes.FIRE}, new PokemonTypes[]{PokemonTypes.NORMAL, PokemonTypes.FLYING, PokemonTypes.ROCK, PokemonTypes.BUG, PokemonTypes.GHOST, PokemonTypes.STEEL, PokemonTypes.GRASS, PokemonTypes.PSYCHIC, PokemonTypes.ICE, PokemonTypes.DRAGON, PokemonTypes.DARK, PokemonTypes.FAIRY}, new PokemonTypes[]{PokemonTypes.POISON}),
	ROCK(new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.GROUND, PokemonTypes.STEEL, PokemonTypes.WATER, PokemonTypes.GRASS}, new PokemonTypes[]{PokemonTypes.NORMAL, PokemonTypes.FLYING, PokemonTypes.POISON, PokemonTypes.FIRE}),
	GROUND(new PokemonTypes[]{PokemonTypes.WATER, PokemonTypes.GRASS, PokemonTypes.ICE}, new PokemonTypes[]{PokemonTypes.POISON, PokemonTypes.ROCK}, new PokemonTypes[]{PokemonTypes.ELECTRIC}),
	DARK(new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.BUG}, new PokemonTypes[]{PokemonTypes.GHOST, PokemonTypes.DARK}, new PokemonTypes[]{PokemonTypes.PSYCHIC}),
	POISON(new PokemonTypes[]{PokemonTypes.GROUND, PokemonTypes.PSYCHIC}, new PokemonTypes[]{PokemonTypes.FIGHTING, PokemonTypes.POISON, PokemonTypes.BUG, PokemonTypes.GRASS, PokemonTypes.FAIRY});
	
	private PokemonTypes[] weakness;
	private PokemonTypes[] resistance;
	private PokemonTypes[] immunities;
	
	private PokemonTypeManipulator(PokemonTypes[] weakness, PokemonTypes[] resistance) {
		this.weakness = weakness;
		this.resistance = resistance;
		this.immunities = null;
	}
	
	private PokemonTypeManipulator(PokemonTypes[] weakness, PokemonTypes[] resistance, PokemonTypes[] immunities) {
		this.weakness = weakness;
		this.resistance = resistance;
		this.immunities = immunities;
	}

	public PokemonTypes[] getWeakness() {
		return weakness;
	}

	public void setWeakness(PokemonTypes[] weakness) {
		this.weakness = weakness;
	}

	public PokemonTypes[] getResistance() {
		return resistance;
	}

	public void setResistance(PokemonTypes[] resistance) {
		this.resistance = resistance;
	}

	public PokemonTypes[] getImmunities() {
		return immunities;
	}

	public void setImmunities(PokemonTypes[] immunities) {
		this.immunities = immunities;
	}	
	
}
