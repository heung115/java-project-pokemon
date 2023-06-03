package Player.Item;

import Player.Player;
import Pokemon.Pokemon;
import java.io.*;

public class Item implements Serializable {
    int itemIndex = 0;
    String itemName;

    /*
     * itemIndex 10 : 몬스터볼
     * itemIndex 11 : 슈퍼볼
     * itemIndex 12 : 하이퍼볼
     * itemIndex 13 : 마스터볼
     * itemIndex 20 : 하급상처약
     * itemIndex 21 : 중급상처약
     * itemIndex 22 : 고급상처약
     * itemIndex 3 : 이상한 사탕
     */
    public void use() {
    }

    public void use(Player player, Pokemon pokemon) {
    }

    public void use(Player player) {
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
