package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity
public class Item extends BaseModel {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private long value;
    private long type;
}