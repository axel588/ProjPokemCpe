package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class OwnedItemDao  implements IRefDao<OwnedItem>/* extends IBaseDao<OwnedItem> */{
    @Query("SELECT * FROM OwnedItem")
    public abstract List<OwnedItem> getAll();

    @Query("SELECT * FROM OwnedItem WHERE id IN (:ownedItemIds)")
    public abstract List<OwnedItem> loadAllByIds(long[] ownedItemIds);

    @Query("DELETE FROM OwnedItem")
    public abstract void deleteAll();

    @Query("SELECT * FROM OwnedItem WHERE OwnedItem.id = :id")
    public abstract OwnedItem findById(long id);

    @Insert
    public abstract void insertAll(OwnedItem... ownedItems);

    @Delete
    public abstract void delete(OwnedItem ownedItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(OwnedItem obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(OwnedItem... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(OwnedItem obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(OwnedItem... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM OwnedItem")
    public abstract void deleteAll();*/
}