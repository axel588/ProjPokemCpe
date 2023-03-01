package fr.cpe.pokemongoplagiat;

import androidx.databinding.BaseObservable;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;

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