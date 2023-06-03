package Player.Item;

import java.util.Scanner;

import Player.Player;

public class Potion extends Item {
    static Scanner scanner = new Scanner(System.in);

    public void use(Player player) {
        System.out.println("사용할 포켓몬을 골라주세요");
        player.showPlayerPokemon();
        int num = scanner.nextInt() - 1;
        System.out.println(num);
        int healAmount = 100;

        player.setPlayerPokemonHp(num, -healAmount);
        System.out.println(player.getPlayerPokemonName(num) + "의 체력이 " + healAmount + "만큼 회복되었습니다");
    }

    public Potion() {
        this.itemIndex = 1;
        this.itemName = "상처약";
    }
}
