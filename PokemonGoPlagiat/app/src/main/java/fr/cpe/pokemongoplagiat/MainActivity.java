package fr.cpe.pokemongoplagiat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import fr.cpe.pokemongoplagiat.databinding.ActivityMainBindingImpl;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.Pokemon;


import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBindingImpl binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main);
        showStartup();
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

        FragmentTransaction transaction = manager.beginTransaction();

        PokedexFragment fragment = new PokedexFragment();
        fragment.setOnClickOnNoteListener(listener);
        fragment.setOnClickOnPokemonFromListListener(listener_one_pokemon);

        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }

}