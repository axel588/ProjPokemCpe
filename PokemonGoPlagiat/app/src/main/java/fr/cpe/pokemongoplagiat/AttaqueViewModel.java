package fr.cpe.pokemongoplagiat;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

import fr.cpe.pokemongoplagiat.bdddao.relation.AttackPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAnnulerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaqueListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaquerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnInventaireListener;

public class AttaqueViewModel extends BaseObservable {

    private Pokemon pokemonAttaque = new Pokemon();
    private WildPokemonPokemon wildPokemonAttaque= new WildPokemonPokemon();

    private OwnedPokemonPokemon ownedPokemon = new  OwnedPokemonPokemon();
    private Pokemon myPokemon = new  Pokemon();

    public OnClickOnAttaqueListener listener;
    public OnClickOnInventaireListener listenerInventaire;
    public OnClickOnEchangerListener listenerEchanger;
    public OnClickOnFuireListener listenerFuire;

    public OnClickOnAttaquerPokemonListener listenerAttaquer;
    public OnClickOnAnnulerListener listenerAnnuler;

    public List<Attack> attackPokemonWild;
    public List<Attack> attackOwnedPokemon;

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


    public void setPokemennAttaque(WildPokemonPokemon pokemonAttaque)
    {
        this. wildPokemonAttaque = pokemonAttaque;
        this.pokemonAttaque = pokemonAttaque.getPokemon();
    }

    public void setMyPokemon(OwnedPokemonPokemon myPokemonRec)
    {
        this.ownedPokemon = myPokemonRec;
        this.myPokemon = myPokemonRec.getPokemon();
    }

    public long getDamageMyPokemon (int indexAttack)
    {
        if (indexAttack < attackOwnedPokemon.size()) {
            return attackOwnedPokemon.get(indexAttack).getDamage();
        }
        else
        {
            return attackOwnedPokemon.get(attackOwnedPokemon.size()-1).getDamage();
        }
    }

    public long getDamageWildPokemon (int indexAttack)
    {
        if (indexAttack < attackPokemonWild.size()) {
            return attackPokemonWild.get(indexAttack).getDamage();
        }
        else
        {
            return attackPokemonWild.get(attackPokemonWild.size()-1).getDamage();
        }
    }

    public void subPvMyPokemon(long valeur)
    {
        setOwnedPokemonPv((int)(this.ownedPokemon.getOwnedPokemon().getPv() - valeur + this.ownedPokemon.getOwnedPokemon().getLevel()*2));
    }

    public void subPvWildPokemon(long valeur)
    {
        setAttackPokemonPv((int)(this.wildPokemonAttaque.getWildPokemon().getPv() - valeur + this.wildPokemonAttaque.getWildPokemon().getLevel()*2));

    }

    public Pokemon getPokemonAttaque() {
        return pokemonAttaque;
    }

    public Pokemon getMyPokemon() {
        return myPokemon;
    }

    public void setAttackPokemonWild  (List<Attack> attackPokemonWild)
    {
        this.attackPokemonWild = attackPokemonWild;
    }

    public void setAttackOwnedPokemon  (List<Attack> attackOwnedPokemon)
    {
        this.attackOwnedPokemon = attackOwnedPokemon;
    }

    @Bindable
    public int getPokemonAttaqueIdType1() {return pokemonAttaque.getType1Img();}
    @Bindable
    public int getPokemonAttaqueIdType2() {
        return pokemonAttaque.getType2Img();
    }

    @Bindable
    public int getPvPokemonAttaque(){
        return (int)(((double)wildPokemonAttaque.getWildPokemon().getPv()/
                ((double)wildPokemonAttaque.getWildPokemon().getBase_pv()
                + (double)wildPokemonAttaque.getWildPokemon().getPv_per_level()
                * (double)wildPokemonAttaque.getWildPokemon().getLevel())
                )*100.0);};

    @Bindable
    public int getPvOwnedPokemon(){return (int)(ownedPokemon.getOwnedPokemon().getPv()/(230/ownedPokemon.getOwnedPokemon().getLevel()))*100;};

    @Bindable
    public String getTest()
    {
        return "test";
    }


    public String getNameAttackOwnedPokemon(int i)
    {
        if (i < attackOwnedPokemon.size()) {
            return attackOwnedPokemon.get(i).getTitle();
        }
        else
        {
            return "Attaque " + i;
        }
    }

    public String getNameAttackWildPokemon(int i)
    {
        return attackPokemonWild.get(i).getTitle();
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
    public int getAttackingPokemonPv() {return (int)wildPokemonAttaque.getWildPokemon().getPv();}
    @Bindable
    public void setAttackPokemonPv(int pv) {
        wildPokemonAttaque.getWildPokemon().setPv((long)pv);
        notifyChange();
    }

    @Bindable
    public int getOwnedPokemonPv() {return (int)ownedPokemon.getOwnedPokemon().getPv();}
    @Bindable
    public void setOwnedPokemonPv(int pv) {
        ownedPokemon.getOwnedPokemon().setPv((long)pv);
        notifyChange();
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
