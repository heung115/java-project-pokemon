package Main;

import Player.Player;
import java.util.Scanner;
import SaveLoad.Save;

public class Option {
    Scanner scanner = new Scanner(System.in);
    private int choice = 0;

    public Option() {

    }

    public void mainOptionLoop(Player player) {
        while (choice != 4) {
            System.out.println("1.가방보기 \n2.포켓몬 보기 \n3.도감보기\n4.저장하기\n5.돌아가기");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.showBag();
                    break;
                case 2:
                    player.showPlayerPokemon();
                    break;
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
}
