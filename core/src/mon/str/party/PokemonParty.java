package mon.str.party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import mon.str.pokemon.Pokemon;

public class PokemonParty {
	
	private List<Pokemon> party;
	
	public PokemonParty() {
		party = new ArrayList<>(6);
	}
	
	public Collection<Pokemon> getparty() {
		return Collections.unmodifiableList(party);
	}
	
	public boolean addPokemon(Pokemon pokemon) {
		if (party.size() == 6) {
			return false;
		}
		if (party.add(pokemon)) {
			return true;
		}
		return false;
	}
	
	public boolean removePokemon(Pokemon pokemon) {
		if (party.size() < 2) {
			return false;
		}
		if (party.remove(pokemon)) {
			return true;
		}
		return false;
	}
	
	public void removePokemonIndex(int index) {
		party.remove(index);
	}
	
	public void removePokedexId(int pokemonId) {
		int i = 0;
		for (Pokemon p : party) {
			if (p.getPokedexId() == pokemonId) {
				party.remove(i);
			}
			i++;
		}
	}
}
