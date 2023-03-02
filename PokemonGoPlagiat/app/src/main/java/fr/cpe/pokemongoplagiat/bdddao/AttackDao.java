package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class AttackDao implements IRefDao<Attack>/* extends IBaseDao<Attack>*/ {
    //@Query("SELECT * FROM Attack")

    @Query("SELECT * FROM Attack")
    public abstract List<Attack> getAll();

    @Query("SELECT * FROM Attack WHERE Attack.id_pokemon = :idPokemon")
    public abstract List<Attack> getAllByPokemon(long idPokemon);

    @Query("SELECT * FROM Attack WHERE Attack.id = :id")
    public abstract Attack findById(long id);

    @Query("SELECT * FROM Attack WHERE id IN (:attackIds)")
    public abstract List<Attack> loadAllByIds(long[] attackIds);

    @Query("DELETE FROM Attack")
    public abstract void deleteAll();

    @Query("SELECT * FROM Attack WHERE type LIKE :type LIMIT 1")
    public abstract Attack findByType(String type);

    @Insert
    public abstract void insertAll(Attack... attacks);

    @Delete
    public abstract void delete(Attack attack);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Attack obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Attack... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Attack obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Attack... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Attack")
    public abstract void deleteAll();*/
}