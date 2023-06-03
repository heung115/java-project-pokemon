package Player.Item;

import Pokemon.Pokemon;
import Pokemon.LevelPokemon;

public class RareCandy extends Item {

    public RareCandy() {
        this.itemIndex = 30;
        this.itemName = "이상한사탕";
    }

    public void use(Pokemon pokemon) {
        LevelPokemon.giveLevel(pokemon, 1);
    }
}
