package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;

@Dao
public interface OwnedPokemonDao {
    @Query("SELECT * FROM OwnedPokemon")
    List<OwnedPokemon> getAll();

    @Query("SELECT * FROM OwnedPokemon WHERE id IN (:ownedPokemonIds)")
    List<OwnedPokemon> loadAllByIds(long[] ownedPokemonIds);


    @Insert
    void insertAll(OwnedPokemon... ownedPokemons);

    @Delete
    void delete(OwnedPokemon ownedPokemon);
}