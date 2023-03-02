package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bdddao.WildPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;

public class WildPokemonService extends BaseService<WildPokemonDao, WildPokemon> {

    public WildPokemonService() {
        super(WildPokemonDao.class, WildPokemon.class);
    }
}