package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;

@Dao
public interface WildPokemonDao {
    @Query("SELECT * FROM WildPokemon")
    List<WildPokemon> getAll();

    @Query("SELECT * FROM WildPokemon WHERE id IN (:wildPokemonIds)")
    List<WildPokemon> loadAllByIds(long[] wildPokemonIds);

    @Query("SELECT * FROM WildPokemon WHERE lng LIKE :lng LIMIT 1")
    WildPokemon findByLng(double lng);

    @Insert
    void insertAll(WildPokemon... wildPokemons);

    @Delete
    void delete(WildPokemon wildPokemon);
}
