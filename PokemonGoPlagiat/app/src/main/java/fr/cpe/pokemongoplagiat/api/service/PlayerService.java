package fr.cpe.pokemongoplagiat.api.service;



import fr.cpe.pokemongoplagiat.bdddao.PlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.Player;

public class PlayerService extends BaseService<PlayerDao, Player> {

    public PlayerService() {
        super(PlayerDao.class, Player.class);
    }
}