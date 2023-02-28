package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(
        foreignKeys = {
                @ForeignKey(entity = Pokemon.class, parentColumns = "id", childColumns = "id_pokemon"),
                @ForeignKey(entity = PokemonTeam.class, parentColumns = "id", childColumns = "id_pokemon_team")
        }
)
public class OwnedPokemon {
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

    public long getPv() {
        return pv;
    }

    public void setPv(long pv) {
        this.pv = pv;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public long getId_pokemon_team() {
        return id_pokemon_team;
    }

    public void setId_pokemon_team(long id_pokemon_team) {
        this.id_pokemon_team = id_pokemon_team;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long id_pokemon;
    private long pv;
    private long level;
    private long state;
    private long id_pokemon_team;
}