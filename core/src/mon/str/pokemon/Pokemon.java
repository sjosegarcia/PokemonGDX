package mon.str.pokemon;

import java.util.EnumMap;

public class Pokemon {

	private PokemonTypes[] type;
	private EnumMap<PokemonStats, Integer> ev = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> iv = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private PokemonAbilities ability;
	private PokemonAbilities hiddenAbility;
	private int pokedexId;
	private int baseExp;
	private int rareness;
	private int happiness;
	private String internalPokemonName, pokemonName;
	private int numStepsToHatch;
	private float height;
	private float weight;
	private String color;
	private String habitat;
	private String species;
	private String pokedexDescription;
	private String genderRate;
	private String growthRate;
	private int playerY;
	private int enemyY;
	private int altitude;
	
	public Pokemon(String pokemonName, String internalPokemonName, PokemonTypes[] type, EnumMap<PokemonStats, Integer> iv, String genderRate, String growthRate,
			int baseExp, EnumMap<PokemonStats, Integer> ev, int rareness, int happiness, PokemonAbilities ability, PokemonAbilities hiddenAbility, int numStepsToHatch,
			int height, int weight, String color, String habitat, int pokedexId, String species, String pokedexDescription, int playerY, int enemyY, int altitude) {
		this.pokedexId = pokedexId;
		this.pokemonName = pokemonName;
		this.internalPokemonName = internalPokemonName;
		this.type = type;
		this.iv = iv;
		this.genderRate = genderRate;
		this.growthRate = growthRate;
		this.baseExp = baseExp;
		this.ev = ev;
		this.rareness = rareness;
		this.happiness = happiness;
		this.ability = ability;
		this.hiddenAbility = hiddenAbility;
		this.numStepsToHatch = numStepsToHatch;
		this.height= height;
		this.weight = weight;
		this.color = color;
		this.habitat = habitat;
		this.species = species;
		this.pokedexDescription = pokedexDescription;
	}	
	
	public PokemonTypes[] getType() {
		return type;
	}

	public EnumMap<PokemonStats, Integer> getIv() {
		return iv;
	}

	public void setIv(EnumMap<PokemonStats, Integer> iv) {
		this.iv = iv;
	}

	public EnumMap<PokemonStats, Integer> getEv() {
		return ev;
	}

	public void setEv(EnumMap<PokemonStats, Integer> ev) {
		this.ev = ev;
	}

	public int getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getInternalPokemonName() {
		return internalPokemonName;
	}

	public void setInternalPokemonName(String internalPokemonName) {
		this.internalPokemonName = internalPokemonName;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getRareness() {
		return rareness;
	}

	public void setRareness(int rareness) {
		this.rareness = rareness;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
	}

	public PokemonAbilities getAbility() {
		return ability;
	}

	public void setAbility(PokemonAbilities ability) {
		this.ability = ability;
	}

	public PokemonAbilities getHiddenAbility() {
		return hiddenAbility;
	}

	public void setHiddenAbility(PokemonAbilities hiddenAbility) {
		this.hiddenAbility = hiddenAbility;
	}

	public int getNumStepsToHatch() {
		return numStepsToHatch;
	}

	public void setNumStepsToHatch(int numStepsToHatch) {
		this.numStepsToHatch = numStepsToHatch;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getPokedexDescription() {
		return pokedexDescription;
	}

	public void setPokedexDescription(String pokedexDescription) {
		this.pokedexDescription = pokedexDescription;
	}

	public String getGenderRate() {
		return genderRate;
	}

	public void setGenderRate(String genderRate) {
		this.genderRate = genderRate;
	}

	public String getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public void setEnemyY(int enemyY) {
		this.enemyY = enemyY;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
}
