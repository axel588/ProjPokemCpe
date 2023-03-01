package fr.cpe.pokemongoplagiat;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAnnulerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaqueListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaquerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnInventaireListener;

public class AttaqueViewModel extends BaseObservable {

    private Pokemon pokemonAttaque = new Pokemon();
    private Pokemon myPokemon = new Pokemon();

    public OnClickOnAttaqueListener listener;
    public OnClickOnInventaireListener listenerInventaire;
    public OnClickOnEchangerListener listenerEchanger;
    public OnClickOnFuireListener listenerFuire;

    public OnClickOnAttaquerPokemonListener listenerAttaquer;
    public OnClickOnAnnulerListener listenerAnnuler;


    public void setOnClickOnAttaqueListener(OnClickOnAttaqueListener listener)
    {
        this.listener = listener;
    }

    public void setOnClickOnInventaireListener(OnClickOnInventaireListener  listener)
    {
        this.listenerInventaire = listener;
    }

    public void setOnClickOnEchangerListener(OnClickOnEchangerListener listener)
    {
        this.listenerEchanger = listener;
    }

    public void setOnClickOnFuireListener(OnClickOnFuireListener listener)
    {
        this.listenerFuire = listener;
    }

    public void setOnClickOnAttaquerPokemonListener(OnClickOnAttaquerPokemonListener listener)
    {
        this.listenerAttaquer = listener;
    }

    public void setOnClickOnAnnulerListener(OnClickOnAnnulerListener listener)
    {
        this.listenerAnnuler = listener;
    }


    public void runOnClickOnInventaireListener()
    {
        this.listenerInventaire.onClickOnInventaire();
    }

    public void runOnClickOnEchangerListener()
    {
        this.listenerEchanger.onClickOnEchanger();
    }

    public void runOnClickOnFuireListener()
    {
        this.listenerFuire.onClickOnFuire();
    }

    public void runOnClickOnAttaquerPokemonListener(int idAttaquer)
    {
        this.listenerAttaquer.onClickOnAttaquerPokemon(idAttaquer);
    }

    public void runOnClickOnAnnulerListener()
    {
        this.listenerAnnuler.onClickOnAnnuler();
    }


    public void setPokemennAttaque(Pokemon pokemonAttaque)
    {
        this.pokemonAttaque = pokemonAttaque;
    }

    public void setMyPokemon(Pokemon myPokemon)
    {
        this.myPokemon = myPokemon;
    }

    public Pokemon getPokemonAttaque() {
        return pokemonAttaque;
    }

    public Pokemon getMyPokemon() {
        return myPokemon;
    }

    @Bindable
    public int getPokemonAttaqueIdType1() {return pokemonAttaque.getType1Img();}
    @Bindable
    public int getPokemonAttaqueIdType2() {
        return pokemonAttaque.getType2Img();
    }

    @Bindable
    public String getTest()
    {
        return "test";
    }

    public Drawable getPokemonAttaqueFront(Context context) {
        return ResourcesCompat.getDrawable(context.getResources(),
                pokemonAttaque.getFrontRessourceInt(), context.getTheme());
    }

    public void RunArgent()
    {
        this.listener.onClickOnAttaque();
    }
    @Bindable
    public String getPokemonAttaqueName() {
        return pokemonAttaque.getName();
    }
    @Bindable
    public String getPokemonAttaqueType1() {
        return pokemonAttaque.getType1String();
    }

    @Bindable
    public String getPokemonAttaqueType2() {
        if (pokemonAttaque.getType2_() != null)
            return pokemonAttaque.getType2String();
        return "";
    }

    public Drawable getPokemonAttaqueType2Img(Context context, int res) {
        if(res != -1)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }

    public Drawable getPokemonAttaqueType1Img(Context context, int res) {
        if(res != -1)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }

    @Bindable
    public int getMyPokemonIdType1() {return myPokemon.getType1Img();}
    @Bindable
    public int getMyPokemonIdType2() {
        return myPokemon.getType2Img();
    }

    public Drawable getMyPokemonFront(Context context) {
        return ResourcesCompat.getDrawable(context.getResources(),
                myPokemon.getFrontRessourceInt(), context.getTheme());
    }

    @Bindable
    public String getMyPokemonName() {
        return myPokemon.getName();
    }
    @Bindable
    public String getMyPokemonType1() {
        return myPokemon.getType1String();
    }
    @Bindable
    public String getMyPokemonType2() {
        if (pokemonAttaque.getType2_() != null)
            return pokemonAttaque.getType2String();
        return "";
    }

    public Drawable getMyPokemonType2Img(Context context, int res) {
        if(res != -1)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }

    public Drawable getMyPokemonType1Img(Context context, int res) {
        if(res != -1)
            return ResourcesCompat.getDrawable(context.getResources(),
                    res, context.getTheme());
        else
            return null;
    }
}
