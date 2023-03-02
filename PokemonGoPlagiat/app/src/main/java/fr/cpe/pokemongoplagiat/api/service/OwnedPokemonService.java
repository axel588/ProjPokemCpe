package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.bdddao.OwnedPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;

public class OwnedPokemonService extends BaseService<OwnedPokemonDao, OwnedPokemon> {

    public OwnedPokemonService() {
        super(OwnedPokemonDao.class, OwnedPokemon.class);
    }
}