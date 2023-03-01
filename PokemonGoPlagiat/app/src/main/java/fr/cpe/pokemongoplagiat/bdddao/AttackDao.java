package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;

@Dao
public interface AttackDao {
    @Query("SELECT * FROM Attack")
    List<Attack> getAll();

    @Query("SELECT * FROM Attack WHERE id IN (:attackIds)")
    List<Attack> loadAllByIds(long[] attackIds);

    @Query("SELECT * FROM Attack WHERE type LIKE :type LIMIT 1")
    Attack findByType(String type);

    @Insert
    void insertAll(Attack... attacks);

    @Delete
    void delete(Attack attack);

    @Query("DELETE FROM Attack")
    public void deleteAll();
}