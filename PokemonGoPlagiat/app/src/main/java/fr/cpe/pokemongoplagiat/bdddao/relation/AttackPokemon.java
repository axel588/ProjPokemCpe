package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class AttackPokemon {
    @Embedded
    private Attack attack;
    @Relation(parentColumn = "id_pokemon", entityColumn = "id")
    private Pokemon pokemon;
}
