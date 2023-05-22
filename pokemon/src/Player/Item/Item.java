package Player.Item;

import Player.Player;
import Pokemon.Pokemon;
import java.io.*;

public class Item implements Serializable {
    int itemIndex = 0;
    String itemName;

    /*
     * itemIndex 1 : 몬스터볼
     * itemIndex 2 : 상처약
     */
    public void use() {
    }

    public void use(Player player, Pokemon pokemon) {
    }

    public void use(Pokemon pokemon) {
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public String getItemName() {
        return itemName;
    }
}
