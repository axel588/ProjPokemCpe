package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.bdddao.OwnedItemDao;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;

public class OwnedItemService extends BaseService<OwnedItemDao, OwnedItem> {

    public OwnedItemService() {
        super(OwnedItemDao.class, OwnedItem.class);
    }
}