package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.DiscoveredPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.HealStationDao;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.HealStation;

public class HealStationService extends BaseService<HealStationDao, HealStation> {

    public HealStationService() {
        super(HealStationDao.class, HealStation.class);
    }
}