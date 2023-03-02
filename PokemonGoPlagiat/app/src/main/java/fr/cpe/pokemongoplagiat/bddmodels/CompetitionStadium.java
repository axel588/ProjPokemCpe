package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class CompetitionStadium extends BaseModel {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long lat;
    private long lng;
    private String name;
}