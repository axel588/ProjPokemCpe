package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokedexPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PokedexPlayerDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class PokedexPlayerService extends BaseService<PokedexPlayerDao, PokedexPlayer> {

    public PokedexPlayerService() {
        super(PokedexPlayerDao.class, PokedexPlayer.class);
    }
}