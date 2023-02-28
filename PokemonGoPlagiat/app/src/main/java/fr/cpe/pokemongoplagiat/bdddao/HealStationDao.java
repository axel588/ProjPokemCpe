package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.HealStation;

@Dao
public interface HealStationDao {
    @Query("SELECT * FROM HealStation")
    List<HealStation> getAll();

    @Query("SELECT * FROM HealStation WHERE id IN (:healStationIds)")
    List<HealStation> loadAllByIds(long[] healStationIds);


    @Insert
    void insertAll(HealStation... healStations);

    @Delete
    void delete(HealStation healStation);
}