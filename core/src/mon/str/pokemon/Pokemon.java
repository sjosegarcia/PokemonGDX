package mon.str.pokemon;

import java.util.EnumMap;

public class Pokemon {

	private PokemonTypeManipulator[] type;
	private EnumMap<PokemonStats, Integer> ev = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> iv = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private PokemonNatures nature;
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
	
	public Pokemon(String pokemonName, String internalPokemonName, PokemonTypeManipulator[] type, PokemonNatures nature, EnumMap<PokemonStats, Integer> iv, 
			int baseExp, EnumMap<PokemonStats, Integer> ev, int rareness, int happiness, PokemonAbilities ability, PokemonAbilities hiddenAbility, int numStepsToHatch,
			int height, int weight, String color, String habitat, int pokedexId, String species, String pokedexDescription) {
		this.pokedexId = pokedexId;
		this.pokemonName = pokemonName;
		this.internalPokemonName = internalPokemonName;
		this.nature = nature;
		this.type = type;
		this.iv = iv;
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
	
	public PokemonTypeManipulator[] getType() {
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

	public PokemonNatures getNature() {
		return nature;
	}

	public void setNature(PokemonNatures nature) {
		this.nature = nature;
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
}
