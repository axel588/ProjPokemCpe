package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.DiscoveredPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class DiscoveredPokemonPokemonService extends BaseService<DiscoveredPokemonPokemonDao, DiscoveredPokemonPokemon> {

    public DiscoveredPokemonPokemonService() {
        super(DiscoveredPokemonPokemonDao.class, DiscoveredPokemonPokemon.class);
    }
}