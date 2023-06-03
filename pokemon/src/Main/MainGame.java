package Main;

import java.util.Scanner;
import Player.Player;
import Util.*;

public class MainGame {
    Scanner scanner = new Scanner(System.in);
    BattleMode battleMode = new BattleMode();
    AdventureMode adventureMode = new AdventureMode();
    Option option = new Option();
    
    private int choice = 0;

    public void mainGameLoop(Player player) {
        while (choice != 4) {
            Ui.MainGame.printMainGameLoopUi();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    battleMode.mainBattleModeLoop(player);
                    break;
                case 2:
                    adventureMode.adventureRoof(player);
                    break;
                case 3:
                    option.mainOptionLoop(player);
                    break;
                case 4:
                
                    break;
            }
        }

    }

}