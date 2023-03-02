package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;

@Dao
public abstract class AttackPokemonDao  extends IBaseRelationDao<Attack, OwnedPokemon, Pokemon> {

    @Transaction
    @Query("SELECT * FROM Attack INNER JOIN Pokemon ON Attack.id_pokemon = Pokemon.id")
    public abstract List<AttackPokemon> getAll();
    public AttackPokemonDao() {
        super(Attack.class, OwnedPokemon.class, Pokemon.class);
    }
}
