package Player.Item;

import Player.Player;
import Pokemon.Pokemon;

public class MonsterBall extends Item {
    int monsterBallKind = 0;
    static double[] captureRate = new double[] { 1, 1.5, 2, 255 };

    public MonsterBall(String monsterBallName) {
        itemIndex = 1;
        switch (monsterBallName) {
            case "몬스터볼":
                this.monsterBallKind = 0;
                this.itemName = "몬스터볼";
                break;
            case "슈퍼볼":
                this.monsterBallKind = 1;
                this.itemName = "슈퍼볼";
                break;
            case "하이퍼볼":
                this.monsterBallKind = 2;
                this.itemName = "하이퍼볼";
                break;
            case "마스터볼":
                this.monsterBallKind = 3;
                this.itemName = "마스터볼";
                break;
            default:
                throw new IllegalArgumentException("몬스터볼의 이름을 다시 설정해주세요");
        }
    }

    public void use(Player player, Pokemon targetPokemon) {
        System.out.println(captureRateFormula(targetPokemon));
        if (Math.random() < captureRateFormula(targetPokemon)) {
            // capture!
            System.out.println("잡앗다!!");
            player.addPokemonToPlayerPokemonArrayList(targetPokemon);
        } else {
            System.out.println("실패!!!");
        }
    }

    private double captureRateFormula(Pokemon targetPokemon) {
        return (3 * (double) targetPokemon.getMaxHp()
                - 2 * (double) targetPokemon.getCurrentHp() * captureRate[monsterBallKind])
                / (3 * (double) targetPokemon.getMaxHp());
    }
}
