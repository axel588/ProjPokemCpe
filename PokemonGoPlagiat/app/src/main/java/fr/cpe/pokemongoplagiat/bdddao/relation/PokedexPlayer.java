package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;

public class PokedexPlayer {
    @Embedded
    private Pokedex pokedex;
    @Relation(parentColumn = "id_player", entityColumn = "id")
    private Player player;
}