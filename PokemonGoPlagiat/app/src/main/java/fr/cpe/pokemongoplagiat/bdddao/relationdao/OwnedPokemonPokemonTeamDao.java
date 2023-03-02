package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemonTeam;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

@Dao
public abstract class OwnedPokemonPokemonTeamDao extends IBaseRelationDao<OwnedPokemon, Pokemon, PokemonTeam> {
    public OwnedPokemonPokemonTeamDao() {
        super(OwnedPokemon.class, Pokemon.class, PokemonTeam.class);
    }

    @Transaction
    @Query("SELECT * FROM OwnedPokemon INNER JOIN PokemonTeam ON OwnedPokemon.id_pokemon_team = PokemonTeam.id")
    public abstract List<OwnedPokemonPokemonTeam> getAll();
}
