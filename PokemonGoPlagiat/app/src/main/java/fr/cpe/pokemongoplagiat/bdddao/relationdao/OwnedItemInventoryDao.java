package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.InventoryPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemInventory;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import fr.cpe.pokemongoplagiat.bddmodels.Player;

@Dao
public abstract class OwnedItemInventoryDao extends IBaseRelationDao<OwnedItem, Item, Inventory> {
    public OwnedItemInventoryDao() {
        super(OwnedItem.class, Item.class, Inventory.class);
    }

    @Transaction
    @Query("SELECT * FROM OwnedItem INNER JOIN Inventory ON OwnedItem.id_inventory = Inventory.id")
    public abstract List<OwnedItemInventory> getAll();
}