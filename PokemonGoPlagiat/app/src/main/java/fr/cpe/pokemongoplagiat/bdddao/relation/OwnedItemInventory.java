package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;

public class OwnedItemInventory {
    @Embedded
    private OwnedItem ownedItem;
    @Relation(parentColumn = "id_inventory", entityColumn = "id")
    private Inventory inventory;
}
