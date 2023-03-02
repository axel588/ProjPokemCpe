package fr.cpe.pokemongoplagiat.bddmodels;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(
        foreignKeys = {
                @ForeignKey(entity = Item.class, parentColumns = "id", childColumns = "id_item"),
                @ForeignKey(entity = Inventory.class, parentColumns = "id", childColumns = "id_inventory")
        }
)
public class OwnedItem extends BaseModel {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_inventory() {
        return id_inventory;
    }

    public void setId_inventory(long id_inventory) {
        this.id_inventory = id_inventory;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long id_inventory;
    private long amount;
    private long id_item;
}