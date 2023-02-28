package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;

@Dao
public interface DiscoveredPokemonDao {
    @Query("SELECT * FROM DiscoveredPokemon")
    List<DiscoveredPokemon> getAll();

    @Query("SELECT * FROM DiscoveredPokemon WHERE id IN (:discoveredPokemonIds)")
    List<DiscoveredPokemon> loadAllByIds(long[] discoveredPokemonIds);

    @Insert
    void insertAll(DiscoveredPokemon... discoveredPokemons);

    @Delete
    void delete(DiscoveredPokemon discoveredPokemon);
}