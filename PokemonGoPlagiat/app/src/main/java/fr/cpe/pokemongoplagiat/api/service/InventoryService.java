package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.HealStationDao;
import fr.cpe.pokemongoplagiat.bdddao.InventoryDao;
import fr.cpe.pokemongoplagiat.bddmodels.HealStation;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;

public class InventoryService extends BaseService<InventoryDao, Inventory> {

    public InventoryService() {
        super(InventoryDao.class, Inventory.class);
    }
}
