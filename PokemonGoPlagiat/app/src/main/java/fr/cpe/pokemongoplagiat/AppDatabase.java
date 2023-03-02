package fr.cpe.pokemongoplagiat;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddconverter.Converters;
import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.CompetitionStadiumDao;
import fr.cpe.pokemongoplagiat.bdddao.DiscoveredPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.HealStationDao;
import fr.cpe.pokemongoplagiat.bdddao.InventoryDao;
import fr.cpe.pokemongoplagiat.bdddao.ItemDao;
import fr.cpe.pokemongoplagiat.bdddao.OwnedItemDao;
import fr.cpe.pokemongoplagiat.bdddao.OwnedPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.PlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonTeamDao;
import fr.cpe.pokemongoplagiat.bdddao.WildPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.AttackPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.DiscoveredPokemonPokedexDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.DiscoveredPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.InventoryPlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedItemInventoryDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedItemItemDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.OwnedPokemonPokemonTeamDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PlayerPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PokedexPlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PokemonTeamPlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.WildPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.CompetitionStadium;
import fr.cpe.pokemongoplagiat.bddmodels.DiscoveredPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.HealStation;
import fr.cpe.pokemongoplagiat.bddmodels.Inventory;
import fr.cpe.pokemongoplagiat.bddmodels.Item;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedItem;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokedex;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.bddmodels.PokemonTeam;
import fr.cpe.pokemongoplagiat.bddmodels.WildPokemon;

@Database(entities = {
        Attack.class,
        CompetitionStadium.class,
        DiscoveredPokemon.class,
        HealStation.class,
        Inventory.class,
        Item.class,
        OwnedItem.class,
        OwnedPokemon.class,
        Player.class,
        Pokedex.class,
        Pokemon.class,
        PokemonTeam.class,
        WildPokemon.class
}, version = 2)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
    public abstract PlayerPokemonDao playerpokemonDao();
    public abstract ItemDao itemDao();
    public abstract WildPokemonDao wildPokemonDao();
    public abstract PokemonTeamDao pokemonTeamDao();
    public abstract DiscoveredPokemonDao discoveredPokemonDao();
    public abstract PokedexDao pokedexDao();
    public abstract PlayerDao playerDao();
    public abstract InventoryDao inventoryDao();
    public abstract CompetitionStadiumDao competitionStadiumDao();
    public abstract OwnedPokemonDao ownedPokemonDao();
    public abstract OwnedItemDao ownedItemDao();
    public abstract HealStationDao healStationDao();
    public abstract AttackDao attackDao();
    public abstract AttackPokemonDao attackPokemonDao();
    public abstract DiscoveredPokemonPokedexDao discoveredPokemonPokedexDao();
    public abstract DiscoveredPokemonPokemonDao discoveredPokemonPokemonDao();
    public abstract InventoryPlayerDao inventoryPlayerDao();
    public abstract OwnedItemInventoryDao ownedItemInventoryDao();
    public abstract OwnedItemItemDao ownedItemItemDao();
    public abstract OwnedPokemonPokemonDao ownedPokemonPokemonDao();
    public abstract OwnedPokemonPokemonTeamDao ownedPokemonPokemonTeamDao();
    public abstract PokedexPlayerDao pokedexPlayerDao();
    public abstract PokemonTeamPlayerDao pokemonTeamPlayerDao();
    public abstract WildPokemonPokemonDao wildPokemonPokemonDao();

    public <T, M> T getDao(Class<M> clazz) {
        if (PokemonDao.class.equals(clazz)) {
            return (T) pokemonDao();
        }
        else if (PlayerPokemonDao.class.equals(clazz)) {
            return (T) playerpokemonDao();
        } else if (ItemDao.class.equals(clazz)) {
            return (T) itemDao();
        } else if (WildPokemonDao.class.equals(clazz)) {
            return (T) wildPokemonDao();
        } else if (PokemonTeamDao.class.equals(clazz)) {
            return (T) pokemonTeamDao();
        } else if (DiscoveredPokemonDao.class.equals(clazz)) {
            return (T) discoveredPokemonDao();
        } else if (PokedexDao.class.equals(clazz)) {
            return (T) pokedexDao();
        } else if (PlayerDao.class.equals(clazz)) {
            return (T) playerDao();
        } else if (InventoryDao.class.equals(clazz)) {
            return (T) inventoryDao();
        } else if (CompetitionStadiumDao.class.equals(clazz)) {
            return (T) competitionStadiumDao();
        } else if (OwnedPokemonDao.class.equals(clazz)) {
            return (T) ownedPokemonDao();
        } else if (OwnedItemDao.class.equals(clazz)) {
            return (T) ownedItemDao();
        } else if (HealStationDao.class.equals(clazz)) {
            return (T) healStationDao();
        } else if (AttackDao.class.equals(clazz)) {
            return (T) attackDao();
        } else if (AttackPokemonDao.class.equals(clazz)) {
            return (T) attackPokemonDao();
        } else if (DiscoveredPokemonPokedexDao.class.equals(clazz)) {
            return (T) discoveredPokemonPokedexDao();
        } else if (DiscoveredPokemonPokemonDao.class.equals(clazz)) {
            return (T) discoveredPokemonPokemonDao();
        } else if (InventoryPlayerDao.class.equals(clazz)) {
            return (T) inventoryPlayerDao();
        } else if (OwnedItemInventoryDao.class.equals(clazz)) {
            return (T) ownedItemInventoryDao();
        } else if (OwnedItemItemDao.class.equals(clazz)) {
            return (T) ownedItemItemDao();
        } else if (OwnedPokemonPokemonDao.class.equals(clazz)) {
            return (T) ownedPokemonPokemonDao();
        } else if (OwnedPokemonPokemonTeamDao.class.equals(clazz)) {
            return (T) ownedPokemonPokemonTeamDao();
        } else if (PokedexPlayerDao.class.equals(clazz)) {
            return (T) pokedexPlayerDao();
        } else if (PokemonTeamPlayerDao.class.equals(clazz)) {
            return (T) pokemonTeamPlayerDao();
        } else if (WildPokemonPokemonDao.class.equals(clazz)) {
            return (T) wildPokemonPokemonDao();
        }
        throw new IllegalArgumentException("Unknown Dao class: " + clazz.getName());
    }



}