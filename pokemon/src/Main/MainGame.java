package Main;

import java.util.Scanner;
import Player.Player;

public class MainGame {
    Scanner scanner = new Scanner(System.in);
    BattleMode battleMode = new BattleMode();
    private int choice = 0;

    public void mainGameLoop(Player player) {
        while (choice != 4) {
            PrintUi.printMainGameLoopUi();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    battleMode.mainBattleModeLoop(player);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }

    }

}

class PrintUi {
    public static void printMainGameLoopUi() {
        System.out.println("=================///==================");
        System.out.println("1. 배틀 모드");
        System.out.println("2. 어드벤쳐 모드");
        System.out.println("3. 옵션");
        System.out.println("4. 종료");
        System.out.println("=================///==================");
    }
}