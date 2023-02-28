package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Player;

public class InventoryPlayer {
    @Embedded
    private Inventory inventory;
    @Relation(parentColumn = "id_player", entityColumn = "id")
    private Player player;
}