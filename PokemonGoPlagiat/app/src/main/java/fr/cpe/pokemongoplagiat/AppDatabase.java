package fr.cpe.pokemongoplagiat;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

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
}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
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
    public abstract WildPokemonPokemonDao wildPokemonPokemonDao();
}