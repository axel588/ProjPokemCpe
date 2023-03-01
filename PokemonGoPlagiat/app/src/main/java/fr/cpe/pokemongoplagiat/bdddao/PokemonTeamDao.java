package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

@Dao
public interface PokemonTeamDao {
    @Query("SELECT * FROM PokemonTeam")
    List<PokemonTeam> getAll();

    @Query("SELECT * FROM PokemonTeam WHERE id IN (:pokemonTeamIds)")
    List<PokemonTeam> loadAllByIds(long[] pokemonTeamIds);


    @Insert
    void insertAll(PokemonTeam... pokemonTeams);

    @Delete
    void delete(PokemonTeam pokemonTeam);

    @Query("DELETE FROM PokemonTeam")
    public void deleteAll();
}