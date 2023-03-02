package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Item;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class ItemDao   implements IRefDao<Item>/* extends IBaseDao<Item> */{
    @Query("SELECT * FROM Item")
    public abstract List<Item> getAll();

    @Query("SELECT * FROM Item WHERE id IN (:itemIds)")
    public abstract List<Item> loadAllByIds(long[] itemIds);

    @Query("DELETE FROM Item")
    public abstract void deleteAll();

    @Query("SELECT * FROM Item WHERE Item.id = :id")
    public abstract Item findById(long id);

    @Query("SELECT * FROM Item WHERE name LIKE :name LIMIT 1")
    public abstract Item findByName(String name);

    @Insert
    public abstract void insertAll(Item... items);

    @Delete
    public abstract void delete(Item item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Item obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Item... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Item obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Item... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Item")
    public abstract void deleteAll();*/
}