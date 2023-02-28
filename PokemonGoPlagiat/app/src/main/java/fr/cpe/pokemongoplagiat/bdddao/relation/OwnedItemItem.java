package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;

public class OwnedItemItem {
    @Embedded
    private OwnedItem ownedItem;
    @Relation(parentColumn = "id_item", entityColumn = "id")
    private Item item;
}