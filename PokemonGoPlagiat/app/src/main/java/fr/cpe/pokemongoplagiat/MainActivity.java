package fr.cpe.pokemongoplagiat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
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
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
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
import fr.cpe.pokemongoplagiat.databinding.ActivityMainBinding;

//import fr.cpe.pokemongoplagiat.generated.callback.OnClickListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;

//import fr.cpe.pokemongoplagiat.generated.callback.OnClickListener;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnMenuListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showStartup();

        /*AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "poke-plagiat").build();*/
        Thread t = new Thread() {
            public void run() {
                insertDB ();
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ActivityCompat.checkSelfPermission( this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            String[] permissions =
                    {Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this,
                    permissions,1);
        }

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);



        //setContentView(R.layout.activity_main);

    }


    public void showStartup() {
        FragmentManager manager = getSupportFragmentManager();

        //CLick on One Pokemon Item in List
        OnClickOnNoteListener listener = new OnClickOnNoteListener(){
            @Override
            public void onClickOnNote(long noteId){
                showNoteDetail(noteId);
            }

            private void showNoteDetail(long noteId) {
                // First, get the context of the current activity or application
                Context context = getApplicationContext();
                CharSequence text = "Received :"+noteId;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };



        //Details of One pokemon
        OnClickOnPokemonFromListListener listener_one_pokemon = new OnClickOnPokemonFromListListener(){
            @Override
            public void onClickOnNote(Pokemon pokemon){
                showNoteDetail(pokemon);
            }

            private void showNoteDetail(Pokemon pokemon) {
                FragmentTransaction transaction = manager.beginTransaction();
                // First, get the context of the current activity or application
                PokemonFragment fragment = new PokemonFragment();
                fragment.pokemon = pokemon;
                transaction.replace(R.id.fragment_container,fragment);
                transaction.commit();
            }
        };

        OnClickOnMenuListener listener_on_menu = new OnClickOnMenuListener() {
            @Override
            public void onClickOnItem(int index) {
                FragmentTransaction transaction = manager.beginTransaction();
                // First, get the context of the current activity or application
                if(index == 0)
                {
                    PokedexFragment fragment = new PokedexFragment();
                    fragment.setOnClickOnNoteListener(listener);
                    fragment.setOnClickOnPokemonFromListListener(listener_one_pokemon);
                    transaction.replace(R.id.fragment_container,fragment);
                    transaction.commit();
                }

            }
        };

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = manager.beginTransaction();
                // First, get the context of the current activity or application

                if(item.getItemId() == R.id.menu)
                {
                            PokedexFragment fragment = new PokedexFragment();
                            fragment.setOnClickOnNoteListener(listener);
                            fragment.setOnClickOnPokemonFromListListener(listener_one_pokemon);
                            transaction.replace(R.id.fragment_container,fragment);
                            transaction.commit();
                    return true;

                }
                if(item.getItemId() == R.id.maps)
                {
                    PokemonMapFragment fragment = new PokemonMapFragment();
                    transaction.replace(R.id.fragment_container,fragment);
                    transaction.commit();
                    return true;
                }
                if (item.getItemId() == R.id.inventory)
                {
                    AttaqueFragment fragment = new AttaqueFragment();


                    OnClickOnFuireListener FuireListnerAgent = new OnClickOnFuireListener ()
                    {
                        @Override
                        public void onClickOnFuire()
                        {
                            FragmentTransaction transaction = manager.beginTransaction();
                            PokemonMapFragment fragment = new PokemonMapFragment();
                            transaction.replace(R.id.fragment_container,fragment);
                            binding.bottomNavigation.setSelectedItemId(R.id.maps);
                            transaction.commit();
                        }
                    };

                    fragment.setOnClickOnFuireListener(FuireListnerAgent);
                    transaction.replace(R.id.fragment_container,fragment);

                    transaction.commit();
                    return true;
                }
                if (item.getItemId() == R.id.mes_pokemon)
                {
                    AttaqueFragment fragment = new AttaqueFragment();


                    OnClickOnFuireListener FuireListnerAgent = new OnClickOnFuireListener ()
                    {
                        @Override
                        public void onClickOnFuire()
                        {
                            FragmentTransaction transaction = manager.beginTransaction();
                            PokemonMapFragment fragment = new PokemonMapFragment();
                            transaction.replace(R.id.fragment_container,fragment);
                            binding.bottomNavigation.setSelectedItemId(R.id.maps);
                            transaction.commit();
                        }
                    };

                    fragment.setOnClickOnFuireListener(FuireListnerAgent);
                    transaction.replace(R.id.fragment_container,fragment);

                    transaction.commit();
                    return true;
                }
                return false;
            }


        });


        FragmentTransaction transaction = manager.beginTransaction();

        PokedexFragment fragment = new PokedexFragment();
        fragment.setOnClickOnNoteListener(listener);
        fragment.setOnClickOnPokemonFromListListener(listener_one_pokemon);

        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }

    void insertDB()
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "poke-plagiat").build();
        db.wildPokemonDao().deleteAll();
        db.competitionStadiumDao().deleteAll();
        db.ownedItemDao().deleteAll();
        db.itemDao().deleteAll();
        db.inventoryDao().deleteAll();
        db.attackDao().deleteAll();
        db.ownedPokemonDao().deleteAll();
        db.pokemonTeamDao().deleteAll();
        db.discoveredPokemonDao().deleteAll();
        db.pokedexDao().deleteAll();
        db.pokemonDao().deleteAll();
        db.playerDao().deleteAll();
        db.healStationDao().deleteAll();

        PokemonDao pokemonDao = db.pokemonDao();
        List<Pokemon> listPoke = pokemonDao.getAll();
        if (listPoke.size() <= 0)
        {

            Pokemon newPokemona = new Pokemon();
            newPokemona.setId(0);
            newPokemona.setName("Mirai");
            newPokemona.setWeight(8);
            newPokemona.setFrontRessource(R.drawable.p30);
            newPokemona.setType1(POKEMON_TYPE.Electrique.ordinal());
            newPokemona.setIs_legendary(false);
            pokemonDao.insertAll(newPokemona);


            Pokemon newPokemon = new Pokemon();
            newPokemon.setId(1);
            newPokemon.setName("Pikachu");
            newPokemon.setWeight(8);
            newPokemon.setFrontRessource(R.drawable.p1);
            newPokemon.setType1(POKEMON_TYPE.Electrique.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);


            newPokemon = new Pokemon();
            newPokemon.setId(2);
            newPokemon.setName("Pokemouille");
            newPokemon.setWeight(2);
            newPokemon.setFrontRessource(R.drawable.p2);
            newPokemon.setType1(POKEMON_TYPE.Acier.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(3);
            newPokemon.setName("Ratatouille");
            newPokemon.setWeight(80);
            newPokemon.setFrontRessource(R.drawable.p3);
            newPokemon.setType1(POKEMON_TYPE.Combat.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(4);
            newPokemon.setName("Zoro");
            newPokemon.setWeight(5);
            newPokemon.setFrontRessource(R.drawable.p4);
            newPokemon.setType1(POKEMON_TYPE.Eau.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(5);
            newPokemon.setName("Asperguer");
            newPokemon.setWeight(58);
            newPokemon.setFrontRessource(R.drawable.p5);
            newPokemon.setType1(POKEMON_TYPE.Glace.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(6);
            newPokemon.setName("Ecrasmouille");
            newPokemon.setWeight(21);
            newPokemon.setFrontRessource(R.drawable.p6);
            newPokemon.setType1(POKEMON_TYPE.Acier.ordinal());
            newPokemon.setType2(POKEMON_TYPE.Combat.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(7);
            newPokemon.setName("Alouette");
            newPokemon.setWeight(1);
            newPokemon.setFrontRessource(R.drawable.p7);
            newPokemon.setType1(POKEMON_TYPE.Poison.ordinal());
            newPokemon.setType2(POKEMON_TYPE.Dragon.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(8);
            newPokemon.setName("Patpatrouille");
            newPokemon.setWeight(54);
            newPokemon.setFrontRessource(R.drawable.p8);
            newPokemon.setType1(POKEMON_TYPE.Acier.ordinal());
            newPokemon.setType2(POKEMON_TYPE.Normal.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(9);
            newPokemon.setName("Loucoumouille");
            newPokemon.setWeight(21);
            newPokemon.setFrontRessource(R.drawable.p9);
            newPokemon.setType1(POKEMON_TYPE.Fee.ordinal());
            newPokemon.setType2(POKEMON_TYPE.Insecte.ordinal());
            newPokemon.setIs_legendary(false);
            pokemonDao.insertAll(newPokemon);

            newPokemon = new Pokemon();
            newPokemon.setId(10);
            newPokemon.setName("Chatouillou");
            newPokemon.setWeight(1);
            newPokemon.setFrontRessource(R.drawable.p10);
            newPokemon.setType1(POKEMON_TYPE.Fee.ordinal());
            newPokemon.setType2(POKEMON_TYPE.Eau.ordinal());
            newPokemon.setIs_legendary(true);
            pokemonDao.insertAll(newPokemon);
            // List 1 - Electrical attacks
            List<String> electricalAttacks = new ArrayList<String>();
            electricalAttacks.add("Eclair");
            electricalAttacks.add("Foudre");
            electricalAttacks.add("Cage-éclair");
            electricalAttacks.add("Vive-attaque");
            electricalAttacks.add("Morsure");
            electricalAttacks.add("Change Éclair");
            electricalAttacks.add("Tonnerre");
            electricalAttacks.add("Fatal-Foudre");
            electricalAttacks.add("Queue de Fer");
            electricalAttacks.add("Rayon Chargé");
            electricalAttacks.add("Éclair Fou");
            electricalAttacks.add("Rayon Gemme");
            electricalAttacks.add("Éclair Croix");
            electricalAttacks.add("Câlinerie");
            electricalAttacks.add("Jugement");
            electricalAttacks.add("Eclair Gelé");
            electricalAttacks.add("Éclair Noir");
            electricalAttacks.add("Pisto-Poing");
            electricalAttacks.add("Vol-Vie");
            electricalAttacks.add("Foudre Parallèle");

    // List 2 - Fire attacks
            List<String> fireAttacks = new ArrayList<String>();
            fireAttacks.add("Flammèche");
            fireAttacks.add("Déflagration");
            fireAttacks.add("Lance-Flammes");
            fireAttacks.add("Souplesse");
            fireAttacks.add("Flammèche Bleue");
            fireAttacks.add("Feu Follet");
            fireAttacks.add("Nitrocharge");
            fireAttacks.add("Danse Flamme");
            fireAttacks.add("Tempête de Sable");
            fireAttacks.add("Rebondifeu");
            fireAttacks.add("Flamme Éternelle");
            fireAttacks.add("Flamboiement");
            fireAttacks.add("Boutefeu");
            fireAttacks.add("Flammèche Rouge");
            fireAttacks.add("Surchauffe");
            fireAttacks.add("Lance-Soleil");
            fireAttacks.add("Exploforce");
            fireAttacks.add("Canicule");
            fireAttacks.add("Magma Storm");
            fireAttacks.add("Flammèche Vengeresse");

    // List 3 - Steel attacks
            List<String> steelAttacks = new ArrayList<String>();
            steelAttacks.add("Griffe Acier");
            steelAttacks.add("Pisto-Poing");
            steelAttacks.add("Plaie-Croix");
            steelAttacks.add("Tranchodon");
            steelAttacks.add("Tête de Fer");
            steelAttacks.add("Draco-Griffe");
            steelAttacks.add("Météores");
            steelAttacks.add("Tacle Lourd");
            steelAttacks.add("Force-Poigne");
            steelAttacks.add("Lame de Roc");
            steelAttacks.add("Boule Élek");
            steelAttacks.add("Coud'Krâne");
            steelAttacks.add("Éclair Fou");
            steelAttacks.add("Gyro Ball");
            steelAttacks.add("Surchauffe");
            steelAttacks.add("Étincelle");
            steelAttacks.add("Coup de Boule");
            steelAttacks.add("Coup d'Jus");
            steelAttacks.add("Crocs Feu");
            steelAttacks.add("Morsure du Dragon");


            AttackDao attaqueDao = db.attackDao();
            List<Attack> attacs = attaqueDao.getAll();
            List<Pokemon> pokess = pokemonDao.getAll();
            for (int i = 0; i < 20; i++) {
                attacs = attaqueDao.getAll();
                Attack attack = new Attack();
                //attack.setId(i);
                attack.setId_pokemon(pokess.get((int)(((Math.cos(i)+1.0)/2.0)*(pokess.size()-1))).getId());
                attack.setTitle(electricalAttacks.get(i));
                attack.setDescription("Attaque électrique disjonctée");
                attack.setType(POKEMON_TYPE.Electrique.ordinal());
                attack.setDamage(10+i*5);
                attaqueDao.insertAll(attack);
            }

            for (int i = 0; i < 20; i++) {
                Attack attack = new Attack();
                //attack.setId(21+i);
                attack.setId_pokemon(pokess.get((int)(((Math.cos(i+0.44)+1.0)/2.0)*(pokess.size()-1))).getId());
                attack.setTitle(fireAttacks.get(i));
                attack.setDescription("Attaque de feu enflammée");
                attack.setType(POKEMON_TYPE.Feu.ordinal());
                attack.setDamage(10+i*5);
                attaqueDao.insertAll(attack);
            }

            for (int i = 0; i < 20; i++) {
                Attack attack = new Attack();
                //attack.setId(41+ i);
                attack.setTitle(steelAttacks.get(i));
                attack.setId_pokemon(pokess.get((int)(((Math.sin(i+0.84)+1.0)/2.0)*(pokess.size()-1))).getId());
                attack.setDescription("Attaque de fer puissante");
                attack.setType(POKEMON_TYPE.Acier.ordinal());
                attack.setDamage(10+i*5);
                attaqueDao.insertAll(attack);
            }

            HealStationDao healStationDao = db.healStationDao();
            Random rand = new Random();
            for(int v = 0;v< 100; v++)
            {
                HealStation healStation = new HealStation();
                //healStation.setId(v);
                healStation.setLevel(v%3);
                // Generate random lat and lng values for Lyon
                double lyonLat = 45.764043;
                double lyonLng = 4.835659;
                double latOffset = rand.nextDouble() / 100; // generate random offset up to 0.1 degrees
                double lngOffset = rand.nextDouble() / 100; // generate random offset up to 0.1 degrees

                // Set the lat and lng values for the healStation object
                healStation.setLat(lyonLat + latOffset);
                healStation.setLng(lyonLng + lngOffset);
                healStationDao.insertAll(healStation);
            }

            PlayerDao playerDao = db.playerDao();
            Player player = new Player();
            player.setId(1);
            player.setGender(1);
            player.setExperience(0);
            player.setMoney(1000);
            player.setName("Euqi");
            player.setLat(45.764043);
            player.setLat(4.835659);

            playerDao.insertAll(player);
            player = playerDao.getAll().get(0);

            PokemonTeamDao pokemonTeamDao = db.pokemonTeamDao();
            PokemonTeam pokemonTeam = new PokemonTeam();
            pokemonTeam.setId(1);
            pokemonTeam.setLimit(6);
            pokemonTeam.setId_player(player.getId());
            pokemonTeamDao.insertAll(pokemonTeam);
            pokemonTeam = pokemonTeamDao.getAll().get(0);

            PokedexDao pokedexDao = db.pokedexDao();
            Pokedex pokedex = new Pokedex();
            pokedex.setId(1);
            pokedex.setId_player(player.getId());
            pokedexDao.insertAll(pokedex);
            pokedex = pokedexDao.getAll().get(0);

            InventoryDao inventoryDao = db.inventoryDao();
            Inventory inventory = new Inventory();
            inventory.setId(1);
            inventory.setId_player(player.getId());
            inventoryDao.insertAll(inventory);
            inventory = inventoryDao.getAll().get(0);

            ArrayList<String> pokemonItems = new ArrayList<String>();
            pokemonItems.add("Poke Ball");
            pokemonItems.add("Great Ball");
            pokemonItems.add("Ultra Ball");
            pokemonItems.add("Master Ball");
            pokemonItems.add("Safari Ball");
            pokemonItems.add("Level Ball");
            pokemonItems.add("Lure Ball");
            pokemonItems.add("Moon Ball");
            pokemonItems.add("Friend Ball");
            pokemonItems.add("Love Ball");
            pokemonItems.add("Heavy Ball");
            pokemonItems.add("Fast Ball");
            pokemonItems.add("Repeat Ball");
            pokemonItems.add("Timer Ball");
            pokemonItems.add("Nest Ball");
            pokemonItems.add("Net Ball");
            pokemonItems.add("Dive Ball");
            pokemonItems.add("Luxury Ball");
            pokemonItems.add("Premier Ball");

            ItemDao itemDao = db.itemDao();
            for(int c = 0;c<10;c++)
            {
                Item item = new Item();
                //item.setId(c);
                item.setName(pokemonItems.get(c));
                item.setType(c%2);

                itemDao.insertAll(item);
            }
            List<Item> all_items=  itemDao.getAll();

            OwnedItemDao ownedItemDao = db.ownedItemDao();
            for(int v = 0; v<3; v++ )
            {
                OwnedItem ownedItem = new OwnedItem();
                //ownedItem.setId(v);
                ownedItem.setId_item(all_items.get(v).getId());
                ownedItem.setId_inventory(inventory.getId());
                ownedItem.setAmount(100);
            }
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            DiscoveredPokemonDao discoveredPokemonDao = db.discoveredPokemonDao();
            DiscoveredPokemon discoveredPokemon = new DiscoveredPokemon();
            discoveredPokemon.setDate(date);
            discoveredPokemon.setId_pokedex(pokedex.getId());
            discoveredPokemon.setId_pokemon(pokess.get(0).getId());
            discoveredPokemonDao.insertAll(discoveredPokemon);
            discoveredPokemon = discoveredPokemonDao.getAll().get(0);
            //discoveredPokemon.setId(1);

            WildPokemonDao wildPokemonDao = db.wildPokemonDao();
            for(int v = 0;v< 100; v++)
            {
                WildPokemon wildPokemon = new WildPokemon();
                //wildPokemon.setId(v);
                wildPokemon.setId_pokemon(pokess.get(v%10).getId());
                wildPokemon.setLevel(v%3);
                wildPokemon.setPv(v%3*20);
                wildPokemon.setLevel(2+v%3);
                wildPokemon.setState(0);
                // Generate random lat and lng values for Lyon
                double lyonLat = 45.764043;
                double lyonLng = 4.835659;
                double latOffset = rand.nextDouble() / 110; // generate random offset up to 0.1 degrees
                double lngOffset = rand.nextDouble() / 110; // generate random offset up to 0.1 degrees

                // Set the lat and lng values for the healStation object
                wildPokemon.setLat(lyonLat + latOffset);
                wildPokemon.setLng(lyonLng + lngOffset);
                wildPokemonDao.insertAll(wildPokemon);
            }

            OwnedPokemonDao ownedPokemonDao = db.ownedPokemonDao();
            OwnedPokemon ownedPokemon = new OwnedPokemon();
            //ownedPokemon.setId(1);
            ownedPokemon.setLevel(12);
            ownedPokemon.setPv(100);
            ownedPokemon.setState(0);
            ownedPokemon.setId_pokemon_team(pokemonTeam.getId());
            ownedPokemon.setId_pokemon(pokess.get(2).getId());
            ownedPokemonDao.insertAll(ownedPokemon);



        }
    }

}