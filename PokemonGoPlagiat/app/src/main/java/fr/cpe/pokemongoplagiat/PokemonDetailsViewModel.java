package fr.cpe.pokemongoplagiat;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;

public class PokemonDetailsViewModel extends BaseObservable {
    private Pokemon pokemon = new Pokemon();
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;

        notifyChange();
    }

    @Bindable
    public int getFront() {
        return pokemon.getFrontRessourceInt();
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
        if (pokemon.getType2_() != null)
            return pokemon.getType2String();
        return "";
    }
    @Bindable
    public int getIdType1() {return pokemon.getType1Img();}
    @Bindable
    public int getIdType2() {
        return pokemon.getType2Img();
    }

    public Drawable getType2Img(Context context, int res) {
        if(res != -1&& res != 0)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }

    public Drawable getType1Img(Context context, int res) {
        if(res != -1&& res != 0)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
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