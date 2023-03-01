package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

import fr.cpe.pokemongoplagiat.R;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;

@Entity
public class Pokemon {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long order;
    private String name;
    private long weight;
    private long frontRessource;
    private long type1;
    private long type2;
    private boolean is_legendary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getFrontRessource() {
        return frontRessource;
    }
    public int getFrontRessourceInt() {
        return (int)frontRessource;
    }

    public void setFrontRessource(long frontRessource) {
        this.frontRessource = frontRessource;
    }

    public long getType1() {
        return type1;
    }

    public void setType1(long type1) {
        this.type1 = type1;
    }

    public long getType2() {
        return type2;
    }

    public void setType2(long type2) {
        this.type2 = type2;
    }

    public boolean isIs_legendary() {
        return is_legendary;
    }

    public void setIs_legendary(boolean is_legendary) {
        this.is_legendary = is_legendary;
    }









    private POKEMON_TYPE type1_;
    private POKEMON_TYPE type2_;

    public int getType1_img() {
        return type1_img;
    }

    public void setType1_img(int type1_img) {
        this.type1_img = type1_img;
    }

    public int getType2_img() {
        return type2_img;
    }

    public void setType2_img(int type2_img) {
        this.type2_img = type2_img;
    }

    private int type1_img;
    private int type2_img;

    public Pokemon() {
        order = 1;
        name = "Unknown";
        frontRessource = R.drawable.p1;
        type1_ = POKEMON_TYPE.Plante;
    }
    public Pokemon(int order, String name, int frontResource,
                   POKEMON_TYPE type1, POKEMON_TYPE type2, int type1_img, int type2_img) {
        this.order = order;
        this.name = name;
        this.frontRessource = (int)frontResource;
        this.type1_ = type1;
        this.type2_ = type2;
        this.type1_img = type1_img;
        this.type2_img = type2_img;
    }



    public POKEMON_TYPE getType1_() {
        return type1_;
    }
    public void setType1_(POKEMON_TYPE type1) {
        this.type1_ = type1;
    }
    public POKEMON_TYPE getType2_() {
        return type2_;
    }
    public void setType2_(POKEMON_TYPE type2) {
        this.type2_ = type2;
    }
    public String getType1String() {
        return type1_.name();
    }
    public String getType2String() {
        return type2_.name();
    }


    public int getType1Img() {
        return type1_img;
    }
    public void setType1Img(int type1_img) {
        this.type1_img = type1_img;
    }
    public int getType2Img() {
        return type2_img;
    }
    public void setType2Img(int type2_img) {this.type2_img = type2_img;}




}