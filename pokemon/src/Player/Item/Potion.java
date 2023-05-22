package Player.Item;

import Pokemon.Pokemon;

public class Potion extends Item {
    public void use(Pokemon pokemon) {
        pokemon.setHp(-20);
    }

    public Potion() {
        this.itemIndex = 1;
        this.itemName = "상처약";
    }
}
