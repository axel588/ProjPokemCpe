package fr.cpe.pokemongoplagiat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.databinding.PokemonFragmentBinding;

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