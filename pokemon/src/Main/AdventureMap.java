package Main;

import Pokemon.Pokemon;
import Player.Player;
import Util.*;
import java.util.List;
import java.util.Scanner;

public class AdventureMap {
    public AdventureMap() {
    }

    private List<List<String>> mapList = CSVReader.readCSV("pokemon/src/CVSFile/map.csv");
    private String selectedMap[] = new String[80];
    private Player player = new Player("Name");
    private int pos = 0;

    public void initMap(int num) {
        int mapSize = 80;
        String selectMap[] = new String[mapSize];
        for (int i = 0; i < mapSize; i++)
            selectMap[i] = this.mapList.get(num).get(i);
        selectMap[40] = "x";// 초기 위치
        this.selectedMap = selectMap.clone();

        printMap(this.selectedMap);
    }

    public void printMap(String[] map) {

        /*******************
         * SIZE : 10 * 8
         * O : 길
         * S : 샵
         * H : 힐센터
         * B : 부쉬
         * x : 플레이어 위치
         *******************/

        for (int i = 0, k = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++, k++) {
                if (map[k].equals("x"))
                    System.out.printf(" " + map[k] + "  ");
                else
                    System.out.printf("[" + map[k] + "] ");
            }
            System.out.println("\n");
        }
        System.out.println("이동 : 상(1) ,하(2) ,좌(3) ,우(4), 복귀(-1) \n");

    }

    public boolean move(int mapNumber, int key) {
        String place = "";
        for (int i = 0; i < selectedMap.length; i++) {
            if (selectedMap[i].equals("x")) {
                pos = i;
                break;
            }
            ;
        }

        switch (key) {
            case 1: // 위
                try {
                    selectedMap[pos] = this.mapList.get(mapNumber).get(pos);
                    pos -= 10;
                    place = selectedMap[pos];
                    selectedMap[pos] = "x";
                    event(place);
                } catch (ArrayIndexOutOfBoundsException e) {
                    Util.Ui.AdventureModeUi.printCannotGoUi();
                    pos += 10;
                }
                break;
            case 2: // 아래
                try {
                    selectedMap[pos] = this.mapList.get(mapNumber).get(pos);
                    pos += 10;
                    place = selectedMap[pos];
                    selectedMap[pos] = "x";
                    event(place);
                } catch (ArrayIndexOutOfBoundsException e) {
                    Util.Ui.AdventureModeUi.printCannotGoUi();
                    pos -= 10;
                }
                break;
            case 3: // 좌
                if (!(pos % 10 == 0)) {
                    selectedMap[pos] = this.mapList.get(mapNumber).get(pos);
                    pos -= 1;
                    place = selectedMap[pos];
                    selectedMap[pos] = "x";
                    event(place);
                } else {
                    Util.Ui.AdventureModeUi.printCannotGoUi();
                    pos += 1;
                }
                break;
            case 4: // 우
                if (!(pos % 10 == 9)) {
                    selectedMap[pos] = this.mapList.get(mapNumber).get(pos);
                    pos += 1;
                    place = selectedMap[pos];
                    System.out.println(selectedMap[pos]);
                    selectedMap[pos] = "x";
                    event(place);
                } else {
                    Util.Ui.AdventureModeUi.printCannotGoUi();
                    pos -= 1;
                }
                break;
            case -1:
                return false;
            default:
                System.out.println("잘못입력하였습니다.");
                break;

        }
        return true;
    }

    private void event(String place) {
        switch (place) {
            case "B":
                bush();
                break;
            case "H":
                healCenter(player);
                break;
            case "S":
                Util.Ui.tools.clearConsoleScreen();
                shop(player);
                break;
            case "O":
                Util.Ui.tools.clearConsoleScreen();
                printMap(selectedMap);
                break;
        }
    }

    private void bush() {

        int size = 9;// Encyclopedia.csv에 담긴 포켓몬 수
        double a = Math.random();

        if (a > 0.5) {
            Pokemon wildPokemon = new Pokemon(Pokemon.makeRandom(size, true));
            Util.Ui.tools.clearConsoleScreen();
            System.out.println("야생의 " + wildPokemon.getName() + "가 나타났다!");
            // battleMode(wildPokemon);
            // appearingPokemonUi();
        } else {
            // Util.Ui.tools.clearConsoleScreen();
            ;
            printMap(selectedMap);
        }
    }

    private void healCenter(Player player) {

    }

    private void shop(Player player) {
        /**********************************
         * 상처약 : 고급, 중급, 하급
         * 이상한 사탕
         * 몬스터 볼 : 일반, 슈퍼, 하이퍼, 마스터
         ***********************************/
        Scanner choice = new Scanner(System.in);
        boolean roof = true;
        while (roof) {
            Util.Ui.tools.clearConsoleScreen();
            Util.Ui.AdventureModeUi.printShopUi();

            roof = false;
            switch (choice.nextInt()) {
                case 1:
                    Ui.AdventureModeUi.printShowItemUi(0);
                    if(buyItem(0))break;
                    else roof = true; 
                    continue;
                case 2:
                    Ui.AdventureModeUi.printShowItemUi(1);
                    if(buyItem(1))break;
                    else roof = true; 
                    continue;
                case 3:
                    Ui.AdventureModeUi.printShowItemUi(2);
                    if(buyItem(2))break;
                    else roof = true; 
                    continue;
                default:
                    roof = true;
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }
        }
        choice.close();
    }

    private boolean buyItem(int itemNum){
        Scanner choice = new Scanner(System.in);
        boolean roof = true;
        while (roof) {
            roof = false;
            switch (choice.next()) {
                case "Y":case "y":
                    if(itemNum==0) ;//볼구매
                    else if(itemNum==1);//상처약 구매
                    else if(itemNum==2);//사탕 구매
                    return true;
                case "N":case "n":
                    return false;
                default:
                    roof = true;
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }
        }
        choice.close();
        return true;
    }
}
