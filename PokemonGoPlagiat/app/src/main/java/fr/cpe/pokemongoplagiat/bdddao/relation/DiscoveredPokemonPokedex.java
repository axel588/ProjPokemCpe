package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;

public class DiscoveredPokemonPokedex {
    @Embedded
    private DiscoveredPokemon discoveredPokemon;
    @Relation(parentColumn = "id_pokedex", entityColumn = "id")
    private Pokedex pokedex;

    public DiscoveredPokemon getDiscoveredPokemon() {
        return discoveredPokemon;
    }

    public void setDiscoveredPokemon(DiscoveredPokemon discoveredPokemon) {
        this.discoveredPokemon = discoveredPokemon;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }
}
