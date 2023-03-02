package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokemonTeamPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PokemonTeamPlayerDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class PokemonTeamPlayerService extends BaseService<PokemonTeamPlayerDao, PokemonTeamPlayer> {

    public PokemonTeamPlayerService() {
        super(PokemonTeamPlayerDao.class, PokemonTeamPlayer.class);
    }
}