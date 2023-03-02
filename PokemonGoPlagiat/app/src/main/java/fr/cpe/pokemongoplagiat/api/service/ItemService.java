package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.ItemDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.Item;

public class ItemService extends BaseService<ItemDao, Item> {

    public ItemService() {
        super(ItemDao.class, Item.class);
    }
}