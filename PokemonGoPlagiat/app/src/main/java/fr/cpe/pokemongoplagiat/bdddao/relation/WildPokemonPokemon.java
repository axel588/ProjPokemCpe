package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;

public class WildPokemonPokemon {
    public WildPokemon getWildPokemon() {
        return wildPokemon;
    }

    public void setWildPokemon(WildPokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Embedded
    private WildPokemon wildPokemon;
    @Relation(parentColumn = "id_pokemon", entityColumn = "id")
    private Pokemon pokemon;
}