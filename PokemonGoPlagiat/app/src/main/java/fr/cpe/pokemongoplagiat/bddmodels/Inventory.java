package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;
@Entity(
        foreignKeys = @ForeignKey(entity = Player.class, parentColumns = "id", childColumns = "id_player")
)
public class Inventory {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long id_player;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_player() {
        return id_player;
    }

    public void setId_player(long id_player) {
        this.id_player = id_player;
    }
}