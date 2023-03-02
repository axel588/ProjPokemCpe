package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.HealStation;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class HealStationDao  implements IRefDao<HealStation> /* extends IBaseDao<HealStation>*/ {
    @Query("SELECT * FROM HealStation")
    public abstract List<HealStation> getAll();

    @Query("SELECT * FROM HealStation WHERE id IN (:healStationIds)")
    public abstract List<HealStation> loadAllByIds(long[] healStationIds);

    @Query("DELETE FROM HealStation")
    public abstract void deleteAll();

    @Query("SELECT * FROM HealStation WHERE HealStation.id = :id")
    public abstract HealStation findById(long id);

    @Insert
    public abstract void insertAll(HealStation... healStations);

    @Delete
    public abstract void delete(HealStation healStation);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(HealStation obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(HealStation... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(HealStation obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(HealStation... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM HealStation")
    public abstract void deleteAll();*/
}