package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.bdddao.PokemonTeamDao;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;

public class PokemonTeamService extends BaseService<PokemonTeamDao, PokemonTeam> {

    public PokemonTeamService() {
        super(PokemonTeamDao.class, PokemonTeam.class);
    }
}