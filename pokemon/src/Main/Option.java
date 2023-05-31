package Main;

import Player.Player;
import SaveLoad.Save;
import Util.Ui;
import java.util.Scanner;
import java.io.IOException;

public class Option {
    Scanner scanner = new Scanner(System.in);
    private int choice = 0;

    public Option() {

    }

    public void mainOptionLoop(Player player) {
        while (choice != 4) {
            Ui.Option.printOptionUi();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.showBag();
                    break;
                case 2:
                    showInfo(player);
                case 3:
                    player.ShowEncyclopedia();
                    break;
                case 4:
                    Save.savaData(player);
                    break;
                case 5:
                    return;
            }
        }
    }

    private void showInfo(Player player) {
        player.showInfo();
        System.out.println("내용을 확인했으면 엔터를 눌러주세요");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
