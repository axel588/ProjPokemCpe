package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class PokemonTeamDao implements IRefDao<PokemonTeam> /* extends IBaseDao<PokemonTeam>*/{

    @Query("DELETE FROM PokemonTeam")
    public abstract void deleteAll();
    @Query("SELECT * FROM PokemonTeam")
    public abstract List<PokemonTeam> getAll();

    @Query("SELECT * FROM PokemonTeam WHERE id IN (:pokemonTeamIds)")
    public abstract List<PokemonTeam> loadAllByIds(long[] pokemonTeamIds);

    @Query("SELECT * FROM PokemonTeam WHERE PokemonTeam.id = :id")
    public abstract PokemonTeam findById(long id);

    @Insert
    public abstract void insertAll(PokemonTeam... pokemonTeams);

    @Delete
    public abstract void delete(PokemonTeam pokemonTeam);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(PokemonTeam obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(PokemonTeam... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(PokemonTeam obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(PokemonTeam... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM PokemonTeam")
    public void deleteAll();*/
}