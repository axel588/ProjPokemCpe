package fr.cpe.pokemongoplagiat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import fr.cpe.pokemongoplagiat.databinding.ActivityMainBinding;

//import fr.cpe.pokemongoplagiat.generated.callback.OnClickListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAnnulerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;

//import fr.cpe.pokemongoplagiat.generated.callback.OnClickListener;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnMenuListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.Pokemon;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import org.osmdroid.config.Configuration;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showStartup();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "poke-plagiat").build();

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

}