package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.InventoryPlayer;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

@Dao
public abstract class InventoryPlayerDao extends IBaseRelationDao<Inventory, OwnedItem, Player> {
    public InventoryPlayerDao() {
        super(Inventory.class, OwnedItem.class, Player.class);
    }

    @Transaction
    @Query("SELECT * FROM Inventory INNER JOIN Player ON Inventory.id_player = Player.id")
    public abstract List<InventoryPlayer> getAll();
}