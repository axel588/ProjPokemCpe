package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokedex;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
@Dao
public abstract class DiscoveredPokemonPokedexDao extends IBaseRelationDao<DiscoveredPokemon, Pokemon, Pokedex> {
    public DiscoveredPokemonPokedexDao() {
        super(DiscoveredPokemon.class, Pokemon.class, Pokedex.class);
    }

    @Transaction
    @Query("SELECT * FROM DiscoveredPokemon INNER JOIN Pokedex ON DiscoveredPokemon.id_pokedex = Pokedex.id")
    public abstract List<DiscoveredPokemonPokedex> getAll();
}