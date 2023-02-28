package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;

@Dao
public interface OwnedItemDao {
    @Query("SELECT * FROM OwnedItem")
    List<OwnedItem> getAll();

    @Query("SELECT * FROM OwnedItem WHERE id IN (:ownedItemIds)")
    List<OwnedItem> loadAllByIds(long[] ownedItemIds);


    @Insert
    void insertAll(OwnedItem... ownedItems);

    @Delete
    void delete(OwnedItem ownedItem);
}