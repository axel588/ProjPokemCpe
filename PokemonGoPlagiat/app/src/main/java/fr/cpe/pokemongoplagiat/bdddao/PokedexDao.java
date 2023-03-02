package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class PokedexDao implements IRefDao<Pokedex> /* extends IBaseDao<Pokedex>*/ {
    @Query("SELECT * FROM Pokedex")
    public abstract List<Pokedex> getAll();

    @Query("DELETE FROM Pokedex")
    public abstract void deleteAll();

    @Query("SELECT * FROM Pokedex WHERE id IN (:pokedexIds)")
    public abstract List<Pokedex> loadAllByIds(long[] pokedexIds);

    @Query("SELECT * FROM Pokedex WHERE Pokedex.id = :id")
    public abstract Pokedex findById(long id);


    @Insert
    public abstract void insertAll(Pokedex... pokedexes);

    @Delete
    public abstract void delete(Pokedex pokedex);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Pokedex obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Pokedex... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Pokedex obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Pokedex... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Pokedex")
    public abstract  void deleteAll();*/
}
