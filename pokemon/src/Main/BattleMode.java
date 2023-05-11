package Main;

import Player.Player;
import Pokemon.Pokemon;

import java.util.Scanner;

public class BattleMode {
    private int choice = 0;
    Scanner scanner = new Scanner(System.in);
    Player aiPlayer = makeAiPlayer(1);

    public BattleMode() {

    }

    public void mainBattleMode(Player player) {
        while (choice == 4) {
            // TODO ai 전투 과정 만들기
            printBattleGameLoopUi();
            showAiPokemon();
            scanner.nextInt();

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
    private void attack(Player player, Player aiPlayer) {
        printBattleUi(player, aiPlayer);
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

    private void showAiPokemon() {
        aiPlayer.showPlayerPokemon();
    }

    /*
     * for Ui
     */
    private void printBattleGameLoopUi() {
        System.out.println("=================///==================");
        System.out.println("1. 공격");
        System.out.println("2. 교체");
        System.out.println("3. 가방");
        System.out.println("4. 도망가기");
        System.out.println("=================///==================");
    }

    private void printBattleUi(Player player, Player aiPlayer) {
        System.out.println("나 : " + player.getName());
        System.out.println("- 포켓몬 : ");
        player.printPlayerPokemon();
        System.out.println("=======================================");
        System.out.println("상대 : " + aiPlayer.getName());
        System.out.println("- 포켓몬 : ");
        aiPlayer.printPlayerPokemon();
    }
}
