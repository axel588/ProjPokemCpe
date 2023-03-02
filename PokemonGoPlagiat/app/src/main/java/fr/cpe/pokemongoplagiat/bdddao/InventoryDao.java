package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.HealStation;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class InventoryDao   implements IRefDao<Inventory>/* extends IBaseDao<Inventory>*/ {
    @Query("SELECT * FROM Inventory")
    public abstract List<Inventory> getAll();

    @Query("SELECT * FROM Inventory WHERE id IN (:inventoryIds)")
    public abstract List<Inventory> loadAllByIds(long[] inventoryIds);

    @Query("DELETE FROM Inventory")
    public abstract void deleteAll();

    @Query("SELECT * FROM Inventory WHERE Inventory.id = :id")
    public abstract Inventory findById(long id);
    @Insert
    public abstract void insertAll(Inventory... inventories);

    @Delete
    public abstract void delete(Inventory inventory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Inventory obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Inventory... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Inventory obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Inventory... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Inventory")
    public abstract  void deleteAll();*/
}