package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemonTeam;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokedexPlayer;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;
@Dao
public abstract class PokedexPlayerDao  extends IBaseRelationDao<Pokedex, DiscoveredPokemon, Player> {

    public PokedexPlayerDao() {
        super(Pokedex.class, DiscoveredPokemon.class, Player.class);
    }

    @Transaction
    @Query("SELECT * FROM Pokedex INNER JOIN Player ON Pokedex.id_player = Player.id")
    public abstract List<PokedexPlayer> getAll();
}
