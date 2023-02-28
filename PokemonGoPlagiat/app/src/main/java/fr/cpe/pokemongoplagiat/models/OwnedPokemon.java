package fr.cpe.pokemongoplagiat.models;

public class OwnedPokemon extends Pokemon {
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int pv;
    private int level;
    private int state;
}
