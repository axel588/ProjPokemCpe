package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;
import kotlin.jvm.JvmSuppressWildcards;

@Dao
public abstract class CompetitionStadiumDao  implements IRefDao<CompetitionStadium> /*extends IBaseDao<CompetitionStadium>*/ {
    @Query("SELECT * FROM CompetitionStadium")
    public abstract List<CompetitionStadium> getAll();

    @Query("SELECT * FROM CompetitionStadium WHERE CompetitionStadium.id = :id")
    public abstract CompetitionStadium findById(long id);

    @Query("SELECT * FROM CompetitionStadium WHERE id IN (:competitionStadiumIds)")
    public abstract List<CompetitionStadium> loadAllByIds(long[] competitionStadiumIds);

    @Query("DELETE FROM CompetitionStadium")
    public abstract void deleteAll();

    @Query("SELECT * FROM CompetitionStadium WHERE name LIKE :name LIMIT 1")
    public abstract CompetitionStadium findByName(String name);

    @Insert
    public abstract void insertAll(CompetitionStadium... competitionStadiums);

    @Delete
    public abstract void delete(CompetitionStadium competitionStadium);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(CompetitionStadium obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(CompetitionStadium... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(CompetitionStadium obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(CompetitionStadium... objs);


    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

    /*@Query("DELETE FROM CompetitionStadium")
    public abstract void deleteAll();*/
}