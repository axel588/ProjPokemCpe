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
import fr.cpe.pokemongoplagiat.databinding.AttaqueFragmentBinding;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAnnulerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaqueListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;

public class AttaqueFragment extends Fragment {


    AttaqueViewModel viewModel = new AttaqueViewModel();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        AttaqueFragmentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.attaque_fragment,container,false);


        Pokemon monPokemon = new Pokemon();
        Pokemon pokemonAttaque = new Pokemon();

        monPokemon.setName("bulbizar");
        monPokemon.setFrontRessource((long)getResources().getIdentifier("p1","drawable",
                binding.getRoot().getContext().getPackageName()));
        monPokemon.setType1_(POKEMON_TYPE.Acier);
        monPokemon.setType2_(POKEMON_TYPE.Feu);
        monPokemon.setType1Img(R.drawable.acier);
        monPokemon.setType2Img(R.drawable.feu);

        pokemonAttaque.setName("totogro");
        pokemonAttaque.setFrontRessource((long)getResources().getIdentifier("p10","drawable",
                binding.getRoot().getContext().getPackageName()));
        pokemonAttaque.setType1_(POKEMON_TYPE.Glace);
        pokemonAttaque.setType1Img(R.drawable.glace);



        viewModel.setPokemennAttaque(pokemonAttaque);
        viewModel.setMyPokemon(monPokemon);
        //viewModel.setPokemon(pokemon);



        OnClickOnAttaqueListener argent = new OnClickOnAttaqueListener()
        {
            @Override
            public void onClickOnAttaque()
            {
                binding.buttonAttaquer.setVisibility(View.GONE);
                binding.buttonFuir.setVisibility(View.GONE);
                binding.buttonInventaire.setVisibility(View.GONE);
                binding.buttonEchanger.setVisibility(View.GONE);
                binding.buttonAnnuler.setVisibility(View.VISIBLE);
            }
        };

        OnClickOnAnnulerListener annulerListnerAgent = new OnClickOnAnnulerListener ()
        {
            @Override
            public void onClickOnAnnuler()
            {
                binding.buttonAttaquer.setVisibility(View.VISIBLE);
                binding.buttonFuir.setVisibility(View.VISIBLE);
                binding.buttonInventaire.setVisibility(View.VISIBLE);
                binding.buttonEchanger.setVisibility(View.VISIBLE);
                binding.buttonAnnuler.setVisibility(View.GONE);
            }
        };

        viewModel.setOnClickOnAnnulerListener(annulerListnerAgent);
        viewModel.setOnClickOnAttaqueListener(argent);
        binding.setAttaqueViewModel(viewModel);
            /*@Override
            public boolean OnClickOnAttaqueListener(@NonNull MenuItem item) {
                FragmentTransaction transaction = manager.beginTransaction();
            }*/

        return binding.getRoot();
    }

    public void setOnClickOnFuireListener(OnClickOnFuireListener listener)
    {
        viewModel.setOnClickOnFuireListener(listener);
    }

}
