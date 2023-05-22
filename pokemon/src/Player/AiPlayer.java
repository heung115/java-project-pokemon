package Player;

import Pokemon.Pokemon;
import java.util.Collections;

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

    @Override
    public void changePokemon(int num1, int num2) {
        System.out.println((playerPokemon.get(num1)).getName() + "이/가 " + (playerPokemon.get(num2)).getName() + "로 교체되었습니다");
        Collections.swap(playerPokemon, num1, num2);
    }
}
