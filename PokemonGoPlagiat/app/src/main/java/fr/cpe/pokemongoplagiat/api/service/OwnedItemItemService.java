package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemItem;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedItemItemDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;

public class OwnedItemItemService extends BaseService<OwnedItemItemDao, OwnedItemItem> {

    public OwnedItemItemService() {
        super(OwnedItemItemDao.class, OwnedItemItem.class);
    }
}