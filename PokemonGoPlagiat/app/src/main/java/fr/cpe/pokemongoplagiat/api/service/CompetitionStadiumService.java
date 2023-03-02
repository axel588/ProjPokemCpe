package fr.cpe.pokemongoplagiat.api.service;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.CompetitionStadiumDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;

public class CompetitionStadiumService extends BaseService<CompetitionStadiumDao, CompetitionStadium> {

    public CompetitionStadiumService() {
        super(CompetitionStadiumDao.class, CompetitionStadium.class);
    }
}
