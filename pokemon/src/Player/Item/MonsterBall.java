package Player.Item;

import java.util.Scanner;

import Player.Player;
import Pokemon.Pokemon;

public class MonsterBall extends Item {
    int monsterBallKind = 0;
    static double[] captureRate = new double[] { 1, 1.5, 2, 255 };
    static Scanner scanner = new Scanner(System.in);

    public MonsterBall(
            String monsterBallName) {
        switch (monsterBallName) {
            case "몬스터볼":
                this.monsterBallKind = 0;
                this.itemIndex = 10;
                this.itemName = "몬스터볼";
                break;
            case "슈퍼볼":
                this.monsterBallKind = 1;
                this.itemIndex = 11;
                this.itemName = "슈퍼볼";
                break;
            case "하이퍼볼":
                this.monsterBallKind = 2;
                this.itemIndex = 12;
                this.itemName = "하이퍼볼";
                break;
            case "마스터볼":
                this.monsterBallKind = 3;
                this.itemIndex = 13;
                this.itemName = "마스터볼";
                break;
            default:
                throw new IllegalArgumentException("몬스터볼의 이름을 다시 설정해주세요");
        }
    }

    public void use(Player player, Pokemon targetPokemon) {
        if (Math.random() < captureRateFormula(targetPokemon) && player.getLevel() >= targetPokemon.getLevel()) {
            // capture!
            player.addPokemonToPlayerPokemonArrayList(targetPokemon);
            player.addPokemonToEncyclopedia();
            System.out.println("\n" + targetPokemon.getName() + ", 넌 내꺼야!!!\n");

            if (player.getPokemonArraySize() > 3) {
                System.out.println("가방이 가득찼다...\n 가방에 있는 포켓몬과 교환하기 위해선 [교환할 포켓몬]을 입력해주세요");
                player.showPlayerPokemon();
                int num1 = scanner.nextInt();
                player.changeAllPokemon(num1 - 1, player.getPokemonArraySize() - 1);
            }

        } else if (player.getLevel() < targetPokemon.getLevel()) {
            System.out.println("\n너무 강해서 몬스터볼이 효과가 없다...!");
        } else {
            System.out.println("\n조금만 더 하면 잡을 수 있었는데..!");
        }

    }

    private double captureRateFormula(Pokemon targetPokemon) {
        return (3 * (double) targetPokemon.getMaxHp()
                - 2 * (double) targetPokemon.getCurrentHp()) * captureRate[monsterBallKind]
                / (3 * (double) targetPokemon.getMaxHp());
    }
}
