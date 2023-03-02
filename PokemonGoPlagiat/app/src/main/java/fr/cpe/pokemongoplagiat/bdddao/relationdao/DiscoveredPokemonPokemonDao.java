package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
@Dao
public abstract class DiscoveredPokemonPokemonDao extends IBaseRelationDao<DiscoveredPokemon, Attack, Pokemon> {
    public DiscoveredPokemonPokemonDao() {
        super(DiscoveredPokemon.class, Attack.class, Pokemon.class);
    }

    @Transaction
    @Query("SELECT * FROM DiscoveredPokemon INNER JOIN Pokemon ON DiscoveredPokemon.id_pokemon = Pokemon.id")
    public abstract List<DiscoveredPokemonPokemon> getAll();
}