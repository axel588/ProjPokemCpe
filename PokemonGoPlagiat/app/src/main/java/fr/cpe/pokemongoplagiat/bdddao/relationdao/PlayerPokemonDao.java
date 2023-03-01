package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

@Dao
public interface PlayerPokemonDao {
    @Transaction
    @Query("SELECT * FROM WildPokemon INNER JOIN Pokemon ON WildPokemon.id_pokemon = Pokemon.id")
    public List<WildPokemonPokemon> getAllWildPokemonPokemon();

    @Transaction
    @Query("SELECT * FROM OwnedPokemon " +
            "JOIN Pokemon ON OwnedPokemon.id_pokemon = Pokemon.id " +
            "JOIN PokemonTeam ON OwnedPokemon.id_pokemon_team = PokemonTeam.id " +
            "JOIN Player ON Player.id = PokemonTeam.id_player " +
            "WHERE Player.id=:idPlayer")
    List<OwnedPokemonPokemon> getOwnedPokemonsByPlayerId(Long idPlayer);

}