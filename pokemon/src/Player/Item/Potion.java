package Player.Item;

import java.util.Scanner;

import Player.Player;

public class Potion extends Item {
    static Scanner scanner = new Scanner(System.in);
    private double effect;

    public Potion(String potionName) {
        itemIndex = 2;
        switch (potionName) {
            case "하급 상처약":
                this.effect = 0.3;
                this.itemName = "하급 상처약";
                break;
            case "중급 상처약":
                this.effect = 0.6;
                this.itemName = "중급 상처약";
                break;
            case "고급 상처약":
                this.effect = 1.0;
                this.itemName = "고급 상처약";
                break;
            default:
                throw new IllegalArgumentException("상처약의 이름을 다시 설정해주세요");
        }
    }

    public void use(Player player) {
        System.out.println("사용할 포켓몬을 골라주세요");
        player.showPlayerPokemon();
        int num = scanner.nextInt() - 1;
        System.out.println(num);
        double healAmount = player.getPlayerPokemonMaxHp(num) * this.effect ;

        player.setPlayerPokemonHp(num, (int)-healAmount);
        System.out.println(player.getPlayerPokemonName(num) + "의 체력이 " + (int)healAmount + "만큼 회복되었습니다");
    }
}