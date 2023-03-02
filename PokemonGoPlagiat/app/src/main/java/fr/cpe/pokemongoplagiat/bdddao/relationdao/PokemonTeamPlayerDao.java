package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.PokedexPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokemonTeamPlayer;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

@Dao
public abstract class PokemonTeamPlayerDao   extends IBaseRelationDao<PokemonTeam, OwnedPokemon, Player> {

    public PokemonTeamPlayerDao() {
        super(PokemonTeam.class, OwnedPokemon.class, Player.class);
    }

    @Transaction
    @Query("SELECT * FROM PokemonTeam INNER JOIN Player ON PokemonTeam.id_player = Player.id")
    public abstract List<PokemonTeamPlayer> getAll();
}
