package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.CompetitionStadiumDao;
import fr.cpe.pokemongoplagiat.bdddao.DiscoveredPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;

public class DiscoveredPokemonService  extends BaseService<DiscoveredPokemonDao, DiscoveredPokemon> {

    public DiscoveredPokemonService() {
        super(DiscoveredPokemonDao.class, DiscoveredPokemon.class);
    }
}
