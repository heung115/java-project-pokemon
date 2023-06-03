package Player.Item;

import Pokemon.Pokemon;
import Pokemon.LevelPokemon;

public class RareCandy extends Item {
    LevelPokemon levelPokemon = new LevelPokemon();

    public RareCandy() {
        this.itemIndex = 1;
        this.itemName = "이상한사탕";
    }

    public void use(Pokemon pokemon) {
        levelPokemon.giveLevel(pokemon, 1);
    }
}
