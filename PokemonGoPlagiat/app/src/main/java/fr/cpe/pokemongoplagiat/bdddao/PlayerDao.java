package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class PlayerDao implements IRefDao<Player> /* extends IBaseDao<Player> */{
    @Query("SELECT * FROM Player")
    public abstract List<Player> getAll();

    @Query("SELECT * FROM Player WHERE id IN (:playerIds)")
    public abstract List<Player> loadAllByIds(long[] playerIds);

    @Query("DELETE FROM Player")
    public abstract void deleteAll();

    @Query("SELECT * FROM Player WHERE Player.id = :id")
    public abstract Player findById(long id);

    @Query("SELECT * FROM Player WHERE name LIKE :name LIMIT 1")
    public abstract Player findByName(String name);

    @Insert
    public abstract void insertAll(Player... players);

    @Delete
    public abstract void delete(Player player);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Player obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Player... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Player obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Player... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Player")
    public abstract  void deleteAll();*/

}