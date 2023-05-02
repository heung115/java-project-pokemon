package Main;

import Player.Player;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class BattleMode {
    private int choice = 0;
    Scanner scanner = new Scanner(System.in);
    Player aiPlayer = makeAiPlayer();

    public void mainBattleMode(Player player) {
        while (choice == 4) {
            // TODO ai 전투 과정 만들기
            printBattleGameLoopUi();
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

    }

    private void changePokemon(Player player) {
        player.printPlayerPokemon();
        System.out.println("바꿀 두 포켓몬을 선택하시오.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        player.changePokemon(num1,num2);
    }

    private void run(Player player) {

    }
    /*
     * for Ai
     */

    private Player makeAiPlayer() {
        Player aiPlayer = new Player("Ai");
        return aiPlayer;
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
}
