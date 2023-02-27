package fr.cpe.pokemongoplagiat;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.Pokemon;

public class PokemonMapViewModel extends BaseObservable {
    private Pokemon pokemon = new Pokemon();
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;

        notifyChange();
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    private OnClickOnNoteListener listener;

    public void setOnClickOnNoteListener(OnClickOnNoteListener listener)
    {
        this.listener = listener;
    }

}