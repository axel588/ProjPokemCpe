package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemonTeam;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedPokemonPokemonTeamDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class OwnedPokemonPokemonTeamService extends BaseService<OwnedPokemonPokemonTeamDao, OwnedPokemonPokemonTeam> {

    public OwnedPokemonPokemonTeamService() {
        super(OwnedPokemonPokemonTeamDao.class, OwnedPokemonPokemonTeam.class);
    }
}