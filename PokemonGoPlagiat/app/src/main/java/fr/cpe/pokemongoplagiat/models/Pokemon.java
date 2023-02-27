package fr.cpe.pokemongoplagiat.models;

import fr.cpe.pokemongoplagiat.R;

public class Pokemon {
    private int order;
    private String name;
    private int height;
    private int weight;
    private int frontResource;
    private POKEMON_TYPE type1;
    private POKEMON_TYPE type2;

    private int type1_img;
    private int type2_img;

    public Pokemon() {
        order = 1;
        name = "Unknown";
        frontResource = R.drawable.p1;
        type1 = POKEMON_TYPE.Plante;
    }
    public Pokemon(int order, String name, int frontResource,
                   POKEMON_TYPE type1, POKEMON_TYPE type2, int type1_img, int type2_img) {
        this.order = order;
        this.name = name;
        this.frontResource = frontResource;
        this.type1 = type1;
        this.type2 = type2;
        this.type1_img = type1_img;
        this.type2_img = type2_img;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getFrontResource() {
        return frontResource;
    }
    public void setFrontResource(int frontResource) {
        this.frontResource = frontResource;
    }
    public POKEMON_TYPE getType1() {
        return type1;
    }
    public void setType1(POKEMON_TYPE type1) {
        this.type1 = type1;
    }
    public POKEMON_TYPE getType2() {
        return type2;
    }
    public void setType2(POKEMON_TYPE type2) {
        this.type2 = type2;
    }
    public String getType1String() {
        return type1.name();
    }
    public String getType2String() {
        return type2.name();
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
