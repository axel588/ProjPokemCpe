package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class DiscoveredPokemonDao implements IRefDao<DiscoveredPokemon> /*extends IBaseDao<CompetitionStadium>*/ {
    @Query("SELECT * FROM DiscoveredPokemon")
    public abstract List<DiscoveredPokemon> getAll();

    @Query("SELECT * FROM DiscoveredPokemon WHERE id IN (:discoveredPokemonIds)")
    public abstract List<DiscoveredPokemon> loadAllByIds(long[] discoveredPokemonIds);

    @Query("SELECT * FROM DiscoveredPokemon WHERE DiscoveredPokemon.id = :id")
    public abstract DiscoveredPokemon findById(long id);

    @Insert
    public abstract void insertAll(DiscoveredPokemon... discoveredPokemons);

    @Delete
    public abstract void delete(DiscoveredPokemon discoveredPokemon);

    @Query("DELETE FROM DiscoveredPokemon")
    public abstract void deleteAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(DiscoveredPokemon obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(DiscoveredPokemon... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(DiscoveredPokemon obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(DiscoveredPokemon... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM DiscoveredPokemon")
    public abstract  void deleteAll();*/
}