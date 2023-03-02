package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.WildPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class WildPokemonPokemonService extends BaseService<WildPokemonPokemonDao, WildPokemonPokemon> {

    public WildPokemonPokemonService() {
        super(WildPokemonPokemonDao.class, WildPokemonPokemon.class);
    }
}