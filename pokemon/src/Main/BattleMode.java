package Main;

import Player.Player;
import Pokemon.Pokemon;
import Util.Ui;

import java.util.Scanner;

public class BattleMode {
    private int choice = 0;
    Scanner scanner = new Scanner(System.in);
    // Ui ui = new Ui();
    Player aiPlayer = makeAiPlayer(1);

    public BattleMode() {

    }

    public void mainBattleModeLoop(Player player) {
        while (choice != 4) {
            // TODO ai 전투 과정 만들기
            Ui.BattleModeUi.printBattleGameLoopUi();
            // showAiPokemon();
            choice = scanner.nextInt();
            Ui.BattleModeUi.printBattleUi(player, aiPlayer);
            switch (choice) {
                case 1:
                    attack(player, aiPlayer);
                    break;
                case 2:
                    changePokemon(player);
                    break;
                case 3:

                    break;
                case 4:
                    run(player);
                    break;
            }
        }
    }

    /*
     * for choice battle
     */
    private double circulateEffect(String type1, String type2) {
        int type = -1;
        int pokemonEffectSize = Main.pokemonEffect.size();
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type1.equals(Main.pokemonEffect.get(i).get(0))) {
                type = i;
                break;
            }
        }
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type2.equals(Main.pokemonEffect.get(0).get(i))) {
                return Double.parseDouble(Main.pokemonEffect.get(type).get(i));
            }
        }
        return -1.0;
    }

    private double circulateDamageFormula(Player player1, Player player2) {
        double typeDamage = circulateEffect(player1.getPlayerPokemonType(0), player2.getPlayerPokemonType(0));
        return player1.getPlayerPokemonDamage(0) * typeDamage;
    }

    private void attack(Player player1, Player player2) {
        int damage = (int) circulateDamageFormula(player1, player2);
        player2.setPlayerPokemonHp(0, damage);
        System.out.println(damage + "만큼의 공격 성공");

    }

    private void changePokemon(Player player) {
        player.showPlayerPokemon();
        System.out.println("바꿀 두 포켓몬을 선택하시오.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        player.changePokemon(num1, num2);
    }

    private void run(Player player) {

    }
    /*
     * for Ai
     */

    private Player makeAiPlayer(int aiPlayerLevel) {
        Player aiPlayer = new Player("Ai");
        for (int i = 0; i < 3; i++) {
            // TODO: 나중에 인자로 플레이어 랩 넘기기
            aiPlayer.addPokemonToPlayerPokemonArrayList(makeAiPlayerPokemon(i + 1));
            aiPlayer.giveExpPlayerPokemon(aiPlayerLevel * 10, i);
        }
        return aiPlayer;
    }

    private Pokemon makeAiPlayerPokemon(int levelNum) {
        // TODO: levelNum에 따라서 생성되면 포켓몬 변경로직 작성
        Pokemon pokemon = new Pokemon();
        pokemon.makePokemon(levelNum);
        return pokemon;
    }
}
