package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemInventory;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemItem;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;

@Dao
public abstract class OwnedItemItemDao extends IBaseRelationDao<OwnedItem, Inventory, Item> {
    public OwnedItemItemDao() {
        super(OwnedItem.class, Inventory.class, Item.class);
    }

    @Transaction
    @Query("SELECT * FROM OwnedItem INNER JOIN Item ON OwnedItem.id_item = item.id")
    public abstract List<OwnedItemItem> getAll();
}