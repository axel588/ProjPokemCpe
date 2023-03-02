package fr.cpe.pokemongoplagiat.bdddao.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

public class PokemonTeamPlayer {
    @Embedded
    private PokemonTeam pokemonTeam;
    @Relation(parentColumn = "id_player", entityColumn = "id")
    private Player player;

    public PokemonTeam getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(PokemonTeam pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}