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

    public OwnedItem getOwnedItem() {
        return ownedItem;
    }

    public void setOwnedItem(OwnedItem ownedItem) {
        this.ownedItem = ownedItem;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
