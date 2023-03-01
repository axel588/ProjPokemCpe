package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Player;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM Player")
    List<Player> getAll();

    @Query("SELECT * FROM Player WHERE id IN (:playerIds)")
    List<Player> loadAllByIds(long[] playerIds);

    @Query("SELECT * FROM Player WHERE name LIKE :name LIMIT 1")
    Player findByName(String name);

    @Insert
    void insertAll(Player... players);

    @Delete
    void delete(Player player);

    @Query("DELETE FROM Player")
    public void deleteAll();

}