package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;

@Dao
public interface PokedexDao {
    @Query("SELECT * FROM Pokedex")
    List<Pokedex> getAll();

    @Query("SELECT * FROM Pokedex WHERE id IN (:pokedexIds)")
    List<Pokedex> loadAllByIds(long[] pokedexIds);


    @Insert
    void insertAll(Pokedex... pokedexes);

    @Delete
    void delete(Pokedex pokedex);

    @Query("DELETE FROM Pokedex")
    public void deleteAll();
}
