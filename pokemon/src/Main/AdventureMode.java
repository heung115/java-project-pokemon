package Main;

import Main.AdventureMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdventureMode {

    private AdventureMap map;
    private int mapNumber = 0;

    public AdventureMode() {
        map = new AdventureMap();
        map.initMap(mapNumber);
    }

    public void adventureRoof() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            
            try{
                map.move(mapNumber,scanner.nextInt());
            }catch(InputMismatchException e){
                System.out.println("잘못 입력하였습니다.");
                scanner.nextLine();//버퍼 비우기
            }
        }


    }
    static public void main(String args[]){
        AdventureMode a = new AdventureMode();
        a.adventureRoof();
    }
}
