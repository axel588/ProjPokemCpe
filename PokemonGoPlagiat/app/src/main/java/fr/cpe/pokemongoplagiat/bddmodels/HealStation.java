package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class HealStation extends BaseModel {
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

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private double lat;
    private double lng;
    private long level;
}