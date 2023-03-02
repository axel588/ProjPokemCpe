package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class AttackService  extends BaseService<AttackDao, Attack> {

    public AttackService() {
        super(AttackDao.class, Attack.class);
    }
}