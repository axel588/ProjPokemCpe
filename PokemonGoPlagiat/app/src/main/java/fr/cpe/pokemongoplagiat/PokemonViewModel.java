package fr.cpe.pokemongoplagiat;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.Pokemon;

public class PokemonViewModel extends BaseObservable {
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

    private OnClickOnPokemonFromListListener onClickOnPokemonFromListListener;
    public void setOnClickOnPokemonFromListListener(OnClickOnPokemonFromListListener listener)
    {
        this.onClickOnPokemonFromListListener = listener;
    }

    public void OnClickTest(Pokemon pokemon)
    {
        if(this.onClickOnPokemonFromListListener != null)
        {
            this.onClickOnPokemonFromListListener.onClickOnNote(pokemon);
        }
    }
    @Bindable
    public int getFront() {
        return pokemon.getFrontResource();
    }
    @Bindable
    public String getName() {
        return pokemon.getName();
    }
    @Bindable
    public String getType1() {
        return pokemon.getType1String();
    }
    @Bindable
    public String getType2() {
        if (pokemon.getType2() != null)
            return pokemon.getType2String();
        return "";
    }

    @Bindable
    public String getNumber() {
        return "#"+pokemon.getOrder();
    }
    public Drawable getImage(Context context, int res) {
        if(res != -1)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }
}
