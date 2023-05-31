package Player.Item;

import java.util.Scanner;

import Player.Player;

public class Potion extends Item {
    transient Scanner scanner = new Scanner(System.in);

    public void use(Player player) {
        System.out.println("사용할 포켓몬을 골라주세요");
        player.showPlayerPokemon();
        int num = scanner.nextInt();
        int healAmount = 100;
        player.setPlayerPokemonHp(num, healAmount);
    }

    public Potion() {
        this.itemIndex = 1;
        this.itemName = "상처약";
    }
}
