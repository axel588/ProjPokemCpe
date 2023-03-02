package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemInventory;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedItemInventoryDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class OwnedItemInventoryService extends BaseService<OwnedItemInventoryDao, OwnedItemInventory> {

    public OwnedItemInventoryService() {
        super(OwnedItemInventoryDao.class, OwnedItemInventory.class);
    }
}