package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class OwnedPokemonPokemonService extends BaseService<OwnedPokemonPokemonDao, OwnedPokemonPokemon> {

    public OwnedPokemonPokemonService() {
        super(OwnedPokemonPokemonDao.class, OwnedPokemonPokemon.class);
    }
}