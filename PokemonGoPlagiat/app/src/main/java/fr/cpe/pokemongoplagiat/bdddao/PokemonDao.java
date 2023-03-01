package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

@Dao
public interface PokemonDao {
    @Query("SELECT * FROM Pokemon")
    List<Pokemon> getAll();

    @Query("SELECT * FROM Pokemon WHERE id IN (:pokemonIds)")
    List<Pokemon> loadAllByIds(long[] pokemonIds);

    @Query("SELECT * FROM Pokemon WHERE name LIKE :name LIMIT 1")
    Pokemon findByName(String name);

    @Query("SELECT * FROM Pokemon WHERE id = :id LIMIT 1")
    Pokemon findById(long id);

    @Insert
    void insertAll(Pokemon... pokemons);

    @Delete
    void delete(Pokemon pokemon);

    @Query("DELETE FROM Pokemon")
    public void deleteAll();

}
