package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.api.service.BaseService;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;

public class PokedexService extends BaseService<PokedexDao, Pokedex> {

    public PokedexService() {
        super(PokedexDao.class, Pokedex.class);
    }
}