package Player;

import Pokemon.Pokemon;

public class AiPlayer extends Player {

    public AiPlayer(String playerName) {
        super(playerName);
    }

    public int aiPlayerCanUsePokemon() {
        for (int i = 0; i < availableCombatPokemonCount; i++) {
            Pokemon pokemon = playerPokemon.get(i);
            if (pokemon.getCurrentHp() == 0) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }
}
