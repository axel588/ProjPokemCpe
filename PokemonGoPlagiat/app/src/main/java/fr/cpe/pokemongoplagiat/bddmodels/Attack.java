package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;
@Entity(
        foreignKeys = @ForeignKey(entity = Pokemon.class, parentColumns = "id", childColumns = "id_pokemon")
)
public class Attack {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public long getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(long id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String description;
    private long type;
    private long damage;
    private long id_pokemon;
}