package fr.cpe.pokemongoplagiat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.cpe.pokemongoplagiat.databinding.PokedexFragmentBinding;
import fr.cpe.pokemongoplagiat.databinding.PokemonFragmentBinding;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;
import fr.cpe.pokemongoplagiat.models.Pokemon;

public class PokemonFragment extends Fragment {

    public Pokemon pokemon;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        PokemonFragmentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.pokemon_fragment,container,false);
        PokemonDetailsViewModel viewModel = new PokemonDetailsViewModel();
        viewModel.setPokemon(pokemon);
        binding.setPokemonDetailsViewModel(viewModel);


        return binding.getRoot();
    }
}