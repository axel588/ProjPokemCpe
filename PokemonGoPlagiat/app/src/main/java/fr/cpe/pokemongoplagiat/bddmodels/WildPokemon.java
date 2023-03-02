package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(
        foreignKeys = @ForeignKey(entity = Pokemon.class, parentColumns = "id", childColumns = "id_pokemon")
)
public class WildPokemon extends BaseModel {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private double lat;
    private double lng;
    private long id_pokemon;
    private long level;
    private long pv;
    private long state;

    public int getPv_per_level() {
        return pv_per_level;
    }

    public void setPv_per_level(int pv_per_level) {
        this.pv_per_level = pv_per_level;
    }

    public int getBase_pv() {
        return base_pv;
    }

    public void setBase_pv(int base_pv) {
        this.base_pv = base_pv;
    }

    private int pv_per_level = 2;
    private int base_pv = 20;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(long id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getPv() {
        return pv;
    }


    public void setPv(long pv) {
        this.pv = pv;

    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }
}