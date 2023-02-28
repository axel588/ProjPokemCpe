package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;

@Dao
public interface CompetitionStadiumDao {
    @Query("SELECT * FROM CompetitionStadium")
    List<CompetitionStadium> getAll();

    @Query("SELECT * FROM CompetitionStadium WHERE id IN (:competitionStadiumIds)")
    List<CompetitionStadium> loadAllByIds(long[] competitionStadiumIds);

    @Query("SELECT * FROM CompetitionStadium WHERE name LIKE :name LIMIT 1")
    CompetitionStadium findByName(String name);

    @Insert
    void insertAll(CompetitionStadium... competitionStadiums);

    @Delete
    void delete(CompetitionStadium competitionStadium);
}