package Main;

import java.util.List;
import java.util.Scanner;

import Player.Player;
import Pokemon.Pokemon;
import Util.CSVReader;
import Util.Ui;

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
                Util.Ui.tools.clearConsoleScreen();
                bush();
                printMap(selectedMap);
                break;
            case "H":
                Util.Ui.tools.clearConsoleScreen();
                healCenter(player);
                printMap(selectedMap);
                break;
            case "S":
                Util.Ui.tools.clearConsoleScreen();
                shop(player);
                printMap(selectedMap);
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
            System.out.println("야생의 " + wildPokemon.getName() + "가 나타났다!");
            
        } else {
            printMap(selectedMap);
        }

        return;
    }

    private void healCenter(Player player) {
        Ui.AdventureModeUi.printHealCenterUi();
        for (int i = 0; i < 3; i++) {
            //player.setPlayerPokemonHp(i, -99999);
        }
        return;
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

            switch (choice.nextInt()) {
                case 1://몬스터볼
                    Ui.AdventureModeUi.printShowItemUi(0);
                    buyItem(1);
                    break;
                case 2://상처약
                    Ui.AdventureModeUi.printShowItemUi(1);
                    buyItem(2);
                    break;
                case 3://이상한사탕
                    Ui.AdventureModeUi.printShowItemUi(2);
                    buyItem(3);
                    break;
                case -1: 
                    roof = false;
                    return;
                default:
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }
        }
        choice.close();
    }

    private void buyItem(int itemNum) {
        Scanner choice = new Scanner(System.in);
        boolean roof = true;
        int num;

        while (roof) {
            roof=false;
            switch (choice.next()) {
                case "Y":case "y":
                    System.out.print("구입할 갯수를 입력해주세요 : ");
                    num = choice.nextInt();
                    purchase(itemNum, num);// 볼구매
                    return;
                case "N":case "n":
                    System.out.println("\n구입을 취소하였습니다.");
                    Ui.tools.giveDelay(500);
                    return;
                default:
                    roof=true;
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }
            
        }
        choice.close();
        return;
    }

    private void purchase(int itemNum, int num){
        /******************************************
         * 몬스터볼 : 100$, 150$, 300$, 1000$
         * 상처약 : 100$, 200$, 300$
         * 이상한사탕 : 1000$ 
         ******************************************/
        int itemPrice=0;

        switch(itemNum){
            case 1: itemPrice = 100;
            case 2: itemPrice = 100;
            case 3: itemPrice = 1000;
        }

        if(player.gerMoney() >= (itemPrice * num)){
            player.setMoney(-itemPrice * num);
            player.addItemBag(player.useItemBag(itemNum), num);
            System.out.println("\n아이템 "+num+"개를 구입하였습니다.\n");
            Ui.tools.giveDelay(1000);
        }else{
            System.out.println("\n돈이 부족합니다.\n");
            Ui.tools.giveDelay(1000);
        }

    }
}
