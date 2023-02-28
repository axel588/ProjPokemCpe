package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
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
}