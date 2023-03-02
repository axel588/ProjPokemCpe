package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.PokemonTeamDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemItem;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

@Dao
public abstract class OwnedPokemonPokemonDao extends IBaseRelationDao<OwnedPokemon, PokemonTeam, Pokemon> {
    public OwnedPokemonPokemonDao() {
        super(OwnedPokemon.class, PokemonTeam.class, Pokemon.class);
    }

    @Transaction
    @Query("SELECT * FROM OwnedPokemon INNER JOIN Pokemon ON OwnedPokemon.id_pokemon = Pokemon.id")
    public abstract List<OwnedPokemonPokemon> getAll();

}