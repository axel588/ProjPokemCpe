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

    public OwnedItem getOwnedItem() {
        return ownedItem;
    }

    public void setOwnedItem(OwnedItem ownedItem) {
        this.ownedItem = ownedItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}