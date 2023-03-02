package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class OwnedPokemonDao implements IRefDao<OwnedPokemon> /* extends IBaseDao<OwnedPokemon> */ {
    @Query("SELECT * FROM OwnedPokemon")
    public abstract List<OwnedPokemon> getAll();

    @Query("SELECT * FROM OwnedPokemon WHERE id IN (:ownedPokemonIds)")
    public abstract List<OwnedPokemon> loadAllByIds(long[] ownedPokemonIds);

    @Query("DELETE FROM OwnedPokemon")
    public abstract void deleteAll();

    @Query("SELECT * FROM OwnedPokemon WHERE OwnedPokemon.id = :id")
    public abstract OwnedPokemon findById(long id);


    @Insert
    public abstract void insertAll(OwnedPokemon... ownedPokemons);

    @Delete
    public abstract void delete(OwnedPokemon ownedPokemon);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(OwnedPokemon obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(OwnedPokemon... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(OwnedPokemon obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(OwnedPokemon... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM OwnedPokemon")
    public abstract void deleteAll();*/
}