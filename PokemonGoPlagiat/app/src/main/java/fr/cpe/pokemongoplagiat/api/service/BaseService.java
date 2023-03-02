package fr.cpe.pokemongoplagiat.api.service;

import androidx.room.Dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

import fr.cpe.pokemongoplagiat.AppDatabase;
import fr.cpe.pokemongoplagiat.MainActivity;
import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.CompetitionStadiumDao;
import fr.cpe.pokemongoplagiat.bdddao.DiscoveredPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.HealStationDao;
import fr.cpe.pokemongoplagiat.bdddao.IRefDao;
import fr.cpe.pokemongoplagiat.bdddao.InventoryDao;
import fr.cpe.pokemongoplagiat.bdddao.ItemDao;
import fr.cpe.pokemongoplagiat.bdddao.OwnedItemDao;
import fr.cpe.pokemongoplagiat.bdddao.OwnedPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.PlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.PokedexDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonTeamDao;
import fr.cpe.pokemongoplagiat.bdddao.WildPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokedex;
import fr.cpe.pokemongoplagiat.bdddao.relation.DiscoveredPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.InventoryPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemInventory;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedItemItem;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemonTeam;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokedexPlayer;
import fr.cpe.pokemongoplagiat.bdddao.relation.PokemonTeamPlayer;
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
//import fr.cpe.pokemongoplagiat.bdddao.IBaseDao;

public class BaseService<D, M> {

    public Class<D> d;
    public Class<M> m;
    public BaseService(Class<D> d, Class<M> m)
    {
        this.m = m;
        this.d = d;
    }
    public List<M> getAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<M> all_items = new ArrayList<>();
        FutureTask<List<M>> futureTask = new FutureTask<>(new Callable<List<M>>() {
            @Override
            public List<M> call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                List<M> items = new ArrayList<>();
                if(dao.getClass()==PokemonDao.class)
                {
                    List<Pokemon> items_all = ((PokemonDao)dao).getAll();
                    for(Pokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== AttackDao.class)
                {
                    List<Attack> items_all = ((AttackDao)dao).getAll();
                    for(Attack pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {
                    List<CompetitionStadium> items_all = ((CompetitionStadiumDao)dao).getAll();
                    for(CompetitionStadium pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                    List<DiscoveredPokemon> items_all = ((DiscoveredPokemonDao)dao).getAll();
                    for(DiscoveredPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== HealStationDao.class)
                {
                    List<HealStation> items_all = ((HealStationDao)dao).getAll();
                    for(HealStation pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== InventoryDao.class)
                {
                    List<Inventory> items_all = ((InventoryDao)dao).getAll();
                    for(Inventory pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== ItemDao.class)
                {
                    List<Item> items_all = ((ItemDao)dao).getAll();
                    for(Item pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                    List<OwnedItem> items_all = ((OwnedItemDao)dao).getAll();
                    for(OwnedItem pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                    List<OwnedPokemon> items_all = ((OwnedPokemonDao)dao).getAll();
                    for(OwnedPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PlayerDao.class)
                {
                    List<Player> items_all = ((PlayerDao)dao).getAll();
                    for(Player pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PokedexDao.class)
                {
                    List<Pokedex> items_all = ((PokedexDao)dao).getAll();
                    for(Pokedex pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PokemonDao.class)
                {
                    List<Pokemon> items_all = ((PokemonDao)dao).getAll();
                    for(Pokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                    List<PokemonTeam> items_all = ((PokemonTeamDao)dao).getAll();
                    for(PokemonTeam pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                    List<WildPokemon> items_all = ((WildPokemonDao)dao).getAll();
                    for(WildPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }



                if(dao.getClass()== AttackPokemonDao.class)
                {
                    List<AttackPokemon> items_all = ((AttackPokemonDao)dao).getAll();
                    for(AttackPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== DiscoveredPokemonPokedexDao.class)
                {
                    List<DiscoveredPokemonPokedex> items_all = ((DiscoveredPokemonPokedexDao)dao).getAll();
                    for(DiscoveredPokemonPokedex pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== DiscoveredPokemonPokemonDao.class)
                {
                    List<DiscoveredPokemonPokemon> items_all = ((DiscoveredPokemonPokemonDao)dao).getAll();
                    for(DiscoveredPokemonPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== InventoryPlayerDao.class)
                {
                    List<InventoryPlayer> items_all = ((InventoryPlayerDao)dao).getAll();
                    for(InventoryPlayer pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedItemInventoryDao.class)
                {
                    List<OwnedItemInventory> items_all = ((OwnedItemInventoryDao)dao).getAll();
                    for(OwnedItemInventory pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedItemItemDao.class)
                {
                    List<OwnedItemItem> items_all = ((OwnedItemItemDao)dao).getAll();
                    for(OwnedItemItem pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedPokemonPokemonDao.class)
                {
                    List<OwnedPokemonPokemon> items_all = ((OwnedPokemonPokemonDao)dao).getAll();
                    for(OwnedPokemonPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== OwnedPokemonPokemonTeamDao.class)
                {
                    List<OwnedPokemonPokemonTeam> items_all = ((OwnedPokemonPokemonTeamDao)dao).getAll();
                    for(OwnedPokemonPokemonTeam pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PlayerPokemonDao.class)
                {
                    List<OwnedPokemonPokemon> items_all = ((PlayerPokemonDao)dao).getAll();
                    for(OwnedPokemonPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PokedexPlayerDao.class)
                {
                    List<PokedexPlayer> items_all = ((PokedexPlayerDao)dao).getAll();
                    for(PokedexPlayer pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== PokemonTeamPlayerDao.class)
                {
                    List<PokemonTeamPlayer> items_all = ((PokemonTeamPlayerDao)dao).getAll();
                    for(PokemonTeamPlayer pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                if(dao.getClass()== WildPokemonPokemonDao.class)
                {
                    List<WildPokemonPokemon> items_all = ((WildPokemonPokemonDao)dao).getAll();
                    for(WildPokemonPokemon pokd : items_all)
                    {
                        items.add((M)pokd);
                    }
                }
                return items;
            }
        });

        executor.execute(futureTask);

        try {
            all_items = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return all_items;
    }


    public Boolean insertAll(M... objs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Boolean all_items = Boolean.FALSE;
        FutureTask<Boolean> futureTask = new FutureTask<>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                List<Long> result_ids = new ArrayList<>();
                if(dao.getClass()==PokemonDao.class)
                {
                    List<Pokemon> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Pokemon)pokd);
                    }
                    ((PokemonDao)dao).insertAll(items_all.toArray(new Pokemon[0]));
                }
                if(dao.getClass()== AttackDao.class)
                {
                    List<Attack> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Attack)pokd);
                    }
                    ((AttackDao)dao).insertAll(items_all.toArray(new Attack[0]));
                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {
                    List<CompetitionStadium> items_all = new ArrayList<>();;
                    for(M pokd : objs)
                    {
                        items_all.add((CompetitionStadium)pokd);
                    }
                    ((CompetitionStadiumDao)dao).insertAll(items_all.toArray(new CompetitionStadium[0]));
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                    List<DiscoveredPokemon> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((DiscoveredPokemon)pokd);
                    }
                    ((DiscoveredPokemonDao)dao).insertAll(items_all.toArray(new DiscoveredPokemon[0]));
                }
                if(dao.getClass()== HealStationDao.class)
                {
                    List<HealStation> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((HealStation)pokd);
                    }
                    ((HealStationDao)dao).insertAll(items_all.toArray(new HealStation[0]));
                }
                if(dao.getClass()== InventoryDao.class)
                {
                    List<Inventory> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Inventory)pokd);
                    }
                    ((InventoryDao)dao).insertAll(items_all.toArray(new Inventory[0]));
                }
                if(dao.getClass()== ItemDao.class)
                {
                    List<Item> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Item)pokd);
                    }
                    ((ItemDao)dao).insertAll(items_all.toArray(new Item[0]));
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                    List<OwnedItem> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((OwnedItem)pokd);
                    }
                    ((OwnedItemDao)dao).insertAll(items_all.toArray(new OwnedItem[0]));
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                    List<OwnedPokemon> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((OwnedPokemon)pokd);
                    }
                    ((OwnedPokemonDao)dao).insertAll(items_all.toArray(new OwnedPokemon[0]));
                }
                if(dao.getClass()== PlayerDao.class)
                {
                    List<Player> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Player)pokd);
                    }
                    ((PlayerDao)dao).insertAll(items_all.toArray(new Player[0]));
                }
                if(dao.getClass()== PokedexDao.class)
                {
                    List<Pokedex> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Pokedex)pokd);
                    }
                    ((PokedexDao)dao).insertAll(items_all.toArray(new Pokedex[0]));
                }
                if(dao.getClass()== PokemonDao.class)
                {
                    List<Pokemon> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((Pokemon)pokd);
                    }
                    ((PokemonDao)dao).insertAll(items_all.toArray(new Pokemon[0]));
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                    List<PokemonTeam> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((PokemonTeam)pokd);
                    }
                    ((PokemonTeamDao)dao).insertAll(items_all.toArray(new PokemonTeam[0]));
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                    List<WildPokemon> items_all = new ArrayList<>();
                    for(M pokd : objs)
                    {
                        items_all.add((WildPokemon)pokd);
                    }
                    ((WildPokemonDao)dao).insertAll(items_all.toArray(new WildPokemon[0]));
                }

                return Boolean.TRUE;
            }
        });

        executor.execute(futureTask);

        try {
            all_items = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return all_items;
    }

    public M findById(long id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        M all_items = null;
        FutureTask<M> futureTask = new FutureTask<>(new Callable<M>() {
            @Override
            public M call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                List<Long> result_ids = new ArrayList<>();
                if(dao.getClass()==PokemonDao.class)
                {
                    return (M)((PokemonDao)dao).findById(id);
                }
                if(dao.getClass()== AttackDao.class)
                {
                    return (M)((AttackDao)dao).findById(id);
                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {
                    return (M)((CompetitionStadiumDao)dao).findById(id);
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                    return (M)((DiscoveredPokemonDao)dao).findById(id);
                }
                if(dao.getClass()== HealStationDao.class)
                {
                    return (M)((HealStationDao)dao).findById(id);
                }
                if(dao.getClass()== InventoryDao.class)
                {
                    return (M)((InventoryDao)dao).findById(id);
                }
                if(dao.getClass()== ItemDao.class)
                {
                    return (M)((ItemDao)dao).findById(id);
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                    return (M)((OwnedItemDao)dao).findById(id);
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                    return (M)((OwnedPokemonDao)dao).findById(id);
                }
                if(dao.getClass()== PlayerDao.class)
                {
                    return (M)((PlayerDao)dao).findById(id);
                }
                if(dao.getClass()== PokedexDao.class)
                {
                    return (M)((PokedexDao)dao).findById(id);
                }
                if(dao.getClass()== PokemonDao.class)
                {
                    return (M)((PokemonDao)dao).findById(id);
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                    return (M)((PokemonTeamDao)dao).findById(id);
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                    return (M)((WildPokemonDao)dao).findById(id);
                }

                return null;
            }
        });

        executor.execute(futureTask);

        try {
            all_items = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return all_items;
    }


    public long save(M obj) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        long all_items = -1;
        FutureTask<Long> futureTask = new FutureTask<>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                if(dao.getClass()==PokemonDao.class)
                {
                    return (Long)((PokemonDao)dao).save((Pokemon)obj);
                }
                if(dao.getClass()== AttackDao.class)
                {
                    return (Long)((AttackDao)dao).save((Attack)obj);
                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {
                    return (Long)((CompetitionStadiumDao)dao).save((CompetitionStadium)obj);
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                    return (Long)((DiscoveredPokemonDao)dao).save((DiscoveredPokemon)obj);
                }
                if(dao.getClass()== HealStationDao.class)
                {
                    return (Long)((HealStationDao)dao).save((HealStation)obj);
                }
                if(dao.getClass()== InventoryDao.class)
                {
                    return (Long)((InventoryDao)dao).save((Inventory)obj);
                }
                if(dao.getClass()== ItemDao.class)
                {
                    return (Long)((ItemDao)dao).save((Item)obj);
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                    return (Long)((OwnedItemDao)dao).save((OwnedItem)obj);
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                    return (Long)((OwnedPokemonDao)dao).save((OwnedPokemon)obj);
                }
                if(dao.getClass()== PlayerDao.class)
                {
                    return (Long)((PlayerDao)dao).save((Player)obj);
                }
                if(dao.getClass()== PokedexDao.class)
                {
                    return (Long)((PokedexDao)dao).save((Pokedex)obj);
                }
                if(dao.getClass()== PokemonDao.class)
                {
                    return (Long)((PokemonDao)dao).save((Pokemon)obj);
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                    return (Long)((PokemonTeamDao)dao).save((PokemonTeam)obj);
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                    return (Long)((WildPokemonDao)dao).save((WildPokemon)obj);
                }
                return (long)(-1);
            }
        });

        executor.execute(futureTask);

        try {
            all_items = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return all_items;
    }

    public Boolean deleteAllById(List<M> objs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Boolean result = Boolean.FALSE;
        FutureTask<Boolean> futureTask = new FutureTask<>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                if(dao.getClass()==PokemonDao.class)
                {
                    for(M obj : objs)
                    {
                        ((PokemonDao)dao).delete((Pokemon)obj);
                    }

                }
                if(dao.getClass()== AttackDao.class)
                {
                    for(M obj : objs)
                    {
                        ((AttackDao)dao).delete((Attack)obj);
                    }
                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {
                    for(M obj : objs)
                    {
                        ((CompetitionStadiumDao)dao).delete((CompetitionStadium)obj);
                    }
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                    for(M obj : objs)
                    {
                        ((DiscoveredPokemonDao)dao).delete((DiscoveredPokemon)obj);
                    }
                }
                if(dao.getClass()== HealStationDao.class)
                {
                    for(M obj : objs)
                    {
                        ((HealStationDao)dao).delete((HealStation)obj);
                    }
                }
                if(dao.getClass()== InventoryDao.class)
                {
                    for(M obj : objs)
                    {
                        ((InventoryDao)dao).delete((Inventory)obj);
                    }
                }
                if(dao.getClass()== ItemDao.class)
                {
                    for(M obj : objs)
                    {
                        ((ItemDao)dao).delete((Item)obj);
                    }
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                    for(M obj : objs)
                    {
                        ((OwnedItemDao)dao).delete((OwnedItem)obj);
                    }
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                    for(M obj : objs)
                    {
                        ((OwnedPokemonDao)dao).delete((OwnedPokemon)obj);
                    }
                }
                if(dao.getClass()== PlayerDao.class)
                {
                    for(M obj : objs)
                    {
                        ((PlayerDao)dao).delete((Player)obj);
                    }
                }
                if(dao.getClass()== PokedexDao.class)
                {
                    for(M obj : objs)
                    {
                        ((PokedexDao)dao).delete((Pokedex)obj);
                    }
                }
                if(dao.getClass()== PokemonDao.class)
                {
                    for(M obj : objs)
                    {
                        ((PokemonDao)dao).delete((Pokemon)obj);
                    }
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                    for(M obj : objs)
                    {
                        ((PokemonTeamDao)dao).delete((PokemonTeam)obj);
                    }
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                    for(M obj : objs)
                    {
                        ((WildPokemonDao)dao).delete((WildPokemon)obj);
                    }
                }
                return Boolean.TRUE;
            }
        });

        executor.execute(futureTask);

        try {
            result = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return result;
    }

    public Boolean deleteAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Boolean result = Boolean.FALSE;
        FutureTask<Boolean> futureTask = new FutureTask<>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                AppDatabase db = MainActivity.database;
                D dao = db.getDao(d);
                if(dao.getClass()==PokemonDao.class)
                {
                        ((PokemonDao)dao).deleteAll();
                }
                if(dao.getClass()== AttackDao.class)
                {

                        ((AttackDao)dao).deleteAll();

                }
                if(dao.getClass()== CompetitionStadiumDao.class)
                {

                        ((CompetitionStadiumDao)dao).deleteAll();
                }
                if(dao.getClass()== DiscoveredPokemonDao.class)
                {
                        ((DiscoveredPokemonDao)dao).deleteAll();
                }
                if(dao.getClass()== HealStationDao.class)
                {
                        ((HealStationDao)dao).deleteAll();
                }
                if(dao.getClass()== InventoryDao.class)
                {
                        ((InventoryDao)dao).deleteAll();
                }
                if(dao.getClass()== ItemDao.class)
                {
                        ((ItemDao)dao).deleteAll();
                }
                if(dao.getClass()== OwnedItemDao.class)
                {
                        ((OwnedItemDao)dao).deleteAll();
                }
                if(dao.getClass()== OwnedPokemonDao.class)
                {
                        ((OwnedPokemonDao)dao).deleteAll();
                }
                if(dao.getClass()== PlayerDao.class)
                {
                        ((PlayerDao)dao).deleteAll();
                }
                if(dao.getClass()== PokedexDao.class)
                {
                        ((PokedexDao)dao).deleteAll();
                }
                if(dao.getClass()== PokemonDao.class)
                {
                        ((PokemonDao)dao).deleteAll();
                }
                if(dao.getClass()== PokemonTeamDao.class)
                {
                        ((PokemonTeamDao)dao).deleteAll();
                }
                if(dao.getClass()== WildPokemonDao.class)
                {
                        ((WildPokemonDao)dao).deleteAll();
                }
                return Boolean.TRUE;
            }
        });

        executor.execute(futureTask);

        try {
            result = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle the exception
        }

        executor.shutdown();
        return result;
    }
}
