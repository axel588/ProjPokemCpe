package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class WildPokemonDao implements IRefDao<WildPokemon> /* extends IBaseDao<WildPokemon> */{
    @Query("SELECT * FROM WildPokemon")
    public abstract List<WildPokemon> getAll();

    @Query("SELECT * FROM WildPokemon WHERE id IN (:wildPokemonIds)")
    public abstract List<WildPokemon> loadAllByIds(long[] wildPokemonIds);

    @Query("SELECT * FROM WildPokemon WHERE lng LIKE :lng LIMIT 1")
    public abstract WildPokemon findByLng(double lng);

    @Insert
    public abstract void insertAll(WildPokemon... wildPokemons);

    @Delete
    public abstract void delete(WildPokemon wildPokemon);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(WildPokemon obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(WildPokemon... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(WildPokemon obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(WildPokemon... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    @Query("DELETE FROM WildPokemon")
    public abstract void deleteAll();

    @Query("SELECT * FROM WildPokemon WHERE WildPokemon.id = :id")
    public abstract WildPokemon findById(long id);

    /*@Query("DELETE FROM WildPokemon")
    public abstract  void deleteAll();*/
}
