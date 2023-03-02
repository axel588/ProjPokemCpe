package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

//import fr.cpe.pokemongoplagiat.bdddao.IBaseDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;

@Dao
public abstract class WildPokemonPokemonDao /*extends IBaseDao<WildPokemonPokemon>*/ {
    @Transaction
    @Query("SELECT * FROM WildPokemon INNER JOIN Pokemon ON WildPokemon.id_pokemon = Pokemon.id")
    public abstract List<WildPokemonPokemon> getAllWildPokemonPokemon();

    @Transaction
    @Query("SELECT * FROM WildPokemon INNER JOIN Pokemon ON WildPokemon.id_pokemon = Pokemon.id")
    public abstract List<WildPokemonPokemon> getAll();

    @Transaction
    @Query("SELECT * FROM WildPokemon INNER JOIN Pokemon ON WildPokemon.id_pokemon = Pokemon.id WHERE WildPokemon.id = :wildPokemonId")
    public abstract WildPokemonPokemon getWildPokemonPokemonById(int wildPokemonId);

}
