package fr.cpe.pokemongoplagiat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import fr.cpe.pokemongoplagiat.databinding.ActivityMainBinding;

public class BottomBarMenuFragment  extends Fragment {

    public int menu;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ActivityMainBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.pokemon_fragment,container,false);
        BottomMenuViewModel viewModel = new BottomMenuViewModel();


        return binding.getRoot();
    }
}