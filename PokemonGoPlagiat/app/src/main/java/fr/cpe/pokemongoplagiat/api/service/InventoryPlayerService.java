package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.InventoryPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.InventoryPlayerDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class InventoryPlayerService extends BaseService<InventoryPlayerDao, InventoryPlayer> {

    public InventoryPlayerService() {
        super(InventoryPlayerDao.class, InventoryPlayer.class);
    }
}