package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.AttackPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class AttackPokemonService extends BaseService<AttackPokemonDao, AttackPokemon> {

    public AttackPokemonService() {
        super(AttackPokemonDao.class, AttackPokemon.class);
    }
}