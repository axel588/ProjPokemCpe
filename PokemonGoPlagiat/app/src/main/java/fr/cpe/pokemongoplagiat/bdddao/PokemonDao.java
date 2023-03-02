package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class PokemonDao implements IRefDao<Pokemon> /*extends IBaseDao<Pokemon>*/ {
    @Query("SELECT * FROM Pokemon")
    public abstract List<Pokemon> getAll();

    @Query("DELETE FROM Pokemon")
    public abstract void deleteAll();

    @Query("SELECT * FROM Pokemon WHERE id IN (:pokemonIds)")
    public abstract List<Pokemon> loadAllByIds(long[] pokemonIds);


    @Query("SELECT * FROM Pokemon WHERE name LIKE :name LIMIT 1")
    public abstract Pokemon findByName(String name);

    @Query("SELECT * FROM Pokemon WHERE id = :id LIMIT 1")
    public abstract Pokemon findById(long id);

    @Insert
    public abstract void insertAll(Pokemon... pokemons);

    @Delete
    public abstract void delete(Pokemon pokemon);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(Pokemon obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(Pokemon... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(Pokemon obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(Pokemon... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM Pokemon")
    public abstract  void deleteAll();*/

}
