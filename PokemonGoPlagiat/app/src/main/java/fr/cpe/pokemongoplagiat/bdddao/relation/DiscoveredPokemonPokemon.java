package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class DiscoveredPokemonPokemon {
    @Embedded
    private DiscoveredPokemon discoveredPokemon;
    @Relation(parentColumn = "id_pokemon", entityColumn = "id")
    private Pokemon pokemon;

    public DiscoveredPokemon getDiscoveredPokemon() {
        return discoveredPokemon;
    }

    public void setDiscoveredPokemon(DiscoveredPokemon discoveredPokemon) {
        this.discoveredPokemon = discoveredPokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
