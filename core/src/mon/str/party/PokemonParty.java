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
	
	public void addPokemon(Pokemon pokemon) {
		party.add(pokemon);
	}
	
	public void removePokemon(Pokemon pokemon) {
		party.remove(pokemon);
	}
	
	public void removePokemonId(int index) {
		party.remove(index);
	}
	
	public void clearParty() {
		party.clear();
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
	
	public boolean isEmpty() {
		return party.isEmpty();
	}
	
}
