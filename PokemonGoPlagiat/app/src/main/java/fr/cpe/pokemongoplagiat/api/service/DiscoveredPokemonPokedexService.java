package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokedex;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.AttackPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.DiscoveredPokemonPokedexDao;

public class DiscoveredPokemonPokedexService extends BaseService<DiscoveredPokemonPokedexDao, DiscoveredPokemonPokedex> {

    public DiscoveredPokemonPokedexService() {
        super(DiscoveredPokemonPokedexDao.class, DiscoveredPokemonPokedex.class);
    }
}