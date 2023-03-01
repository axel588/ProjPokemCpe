package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class OwnedPokemonPokemon {
    public OwnedPokemon getOwnedPokemon() {
        return ownedPokemon;
    }

    public void setOwnedPokemon(OwnedPokemon ownedPokemon) {
        this.ownedPokemon = ownedPokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Embedded
    private OwnedPokemon ownedPokemon;
    @Relation(parentColumn = "id_pokemon", entityColumn = "id")
    private Pokemon pokemon;
}