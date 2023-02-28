package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

public class OwnedPokemonPokemonTeam {
    @Embedded
    private OwnedPokemon ownedPokemon;
    @Relation(parentColumn = "id_pokemon_team", entityColumn = "id")
    private PokemonTeam pokemonTeam;
}