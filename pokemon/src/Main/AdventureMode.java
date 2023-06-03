package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Player.Player;

public class AdventureMode {

    private AdventureMap map;
    private int mapNumber = 0;

    public AdventureMode() {
        map = new AdventureMap();
        map.initMap(mapNumber);
    }

    public void adventureRoof(Player player) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                if (!map.move(player,mapNumber, scanner.nextInt()))
                    break;
                ;
            } catch (InputMismatchException e) {
                System.out.println("잘못입력하였습니다.");
                scanner.nextLine();// 버퍼 비우기
            }
        }
        scanner.close();

    }

    static public void main(String args[]) {
        AdventureMode a = new AdventureMode();
        Player player = new Player("name");
        while (true) {
            a.adventureRoof(player);
        }
    }
}
