package mon.str.pokemon;

import mon.str.status.StatusConditions;

public class Pokemon {

	private PokemonTypes[] type;
	private StatusConditions conditions;
	private int pokedexId, level;
	
	public Pokemon() {
		setConditions(StatusConditions.NORMAL);
	}


	public PokemonTypes[] getType() {
		return type;
	}


	public void setType(PokemonTypes[] type) {
		this.type = type;
	}

	public StatusConditions getConditions() {
		return conditions;
	}


	public void setConditions(StatusConditions conditions) {
		this.conditions = conditions;
	}
	
	public int getPokedexId() {
		return pokedexId;
	}
}
