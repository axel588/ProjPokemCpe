package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class OwnedPokemonPokemon {
    @Embedded
    private OwnedPokemon ownedPokemon;
    @Relation(parentColumn = "id_pokemon", entityColumn = "id")
    private Pokemon pokemon;
}