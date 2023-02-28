package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Item;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAll();

    @Query("SELECT * FROM Item WHERE id IN (:itemIds)")
    List<Item> loadAllByIds(long[] itemIds);

    @Query("SELECT * FROM Item WHERE name LIKE :name LIMIT 1")
    Item findByName(String name);

    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);
}