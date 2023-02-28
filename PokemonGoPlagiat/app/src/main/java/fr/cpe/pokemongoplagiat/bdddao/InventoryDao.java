package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Inventory;

@Dao
public interface InventoryDao {
    @Query("SELECT * FROM Inventory")
    List<Inventory> getAll();

    @Query("SELECT * FROM Inventory WHERE id IN (:inventoryIds)")
    List<Inventory> loadAllByIds(long[] inventoryIds);


    @Insert
    void insertAll(Inventory... inventories);

    @Delete
    void delete(Inventory inventory);
}