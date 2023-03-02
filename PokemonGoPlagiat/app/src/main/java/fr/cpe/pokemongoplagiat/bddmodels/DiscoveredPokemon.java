package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.sql.Date;



@Entity(
        foreignKeys = {
                @ForeignKey(entity = Pokemon.class, parentColumns = "id", childColumns = "id_pokemon"),
                @ForeignKey(entity = Pokedex.class, parentColumns = "id", childColumns = "id_pokedex")
        }
        )
public class DiscoveredPokemon extends BaseModel {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(long id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public long getId_pokedex() {
        return id_pokedex;
    }

    public void setId_pokedex(long id_pokedex) {
        this.id_pokedex = id_pokedex;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long id_pokemon;

    private java.sql.Date date;
    private long id_pokedex;
}