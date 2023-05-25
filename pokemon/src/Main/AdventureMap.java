package Main;

import Pokemon.Pokemon;
import Util.*;
import java.util.List;
import java.util.Scanner;


public class AdventureMap {
    
    private List<List<String>> mapList = CSVReader.readCSV("pokemon/src/CVSFile/map.csv");
    AdventureMap(){}

    private String selectedMap[] = new String[80];

    public void initMap(int num){
        int mapSize = 80;
        String selectMap[] = new String[mapSize];
        for(int i=0; i < mapSize;i++) selectMap[i] = this.mapList.get(num).get(i);
        selectMap[40] = "x";//초기 위치
        this.selectedMap = selectedMap.clone();
    }
    
    public void printMap(String[] map){

        /*******************
         * SIZE : 10 * 8
         * O : 길
         * S : 샵
         * H : 힐센터
         * B : 부쉬
         * x : 플레이어 위치
         *******************/

        for(int i=0, k=0; i < 8;i++){
            for(int j=0; j < 10;j++,k++){
                if(map[k].equals("o"))
                System.out.printf(" "+map[k]+"  ");
                else 
                System.out.printf("["+map[k]+"] ");
            }
            System.out.println("");
        }
         
    }

    public String[] move(String[] map, int mapNumber, String key){
        
        int pos = 0;
        for(int i =0 ; i < map.length ;i++){
            if(map[i].equals("x")){
                pos = i;
                break;
            };
        }

        switch(key){
            case "위": 
                try {
                    map[pos] = this.mapList.get(mapNumber).get(pos);
                    pos -= 10;
                    event(map, pos);
                    map[pos] = "x";
                } catch (ArrayIndexOutOfBoundsException e) {
                    //TODO 다른 맵으로 이동
                }
                break;
            case "아래": 
                try {
                    map[pos] = this.mapList.get(mapNumber).get(pos);
                    pos += 10;
                    event(map, pos);
                    map[pos] = "x";
                } catch (ArrayIndexOutOfBoundsException e) {
                    //TODO 다른 맵으로 이동
                }
                break;
            case "오른쪽": 
                if(!(pos % 10 == 9)){
                    map[pos] = this.mapList.get(mapNumber).get(pos);
                    pos += 1;
                    event(map, pos);
                    map[pos] = "x";
                }
                else{ 
                    //TODO 다른 맵으로 이동
                }
                break;
            case "왼쪽": 
                if(!(pos % 10 == 0)){
                    map[pos] = this.mapList.get(mapNumber).get(pos);
                    pos -= 1;
                    event(map, pos);
                    map[pos] = "x";
                }
                else{ 
                    //TODO 다른 맵으로 이동
                }
                break;
        }

        return map;

    }

    private void event(String[] map, int pos){
        switch(map[pos]){
            case "B": bush();break;
            case "H": healCenter(); break;
            case "S": shop(); break;
            case "O": printMap(map); break;
        }
    }

    private void bush(){
        // TODO 포켓몬 등장
        int size = 9;//Encyclopedia.csv에 담긴 포켓몬 수 
        double a = Math.random();
        if(a>5.0){
            Pokemon wildPokemon = new Pokemon(Pokemon.makeRandom(size, false));
            // battleMode(wildPokemon);
            // appearingPokemonUi();
        } 
        else{
            Util.Ui.tools.clearConsoleScreen();;
            printMap(selectedMap);
        }
    }

    private void healCenter(){
        // TODO 포켓몬 힐 기능
    }

    private void shop(){
        // TODO 아이템 구매
        /**********************************
         * 상처약 : 고급, 중급, 하급
         * 이상한 사탕
         * 몬스터 볼 : 일반, 슈퍼, 하이퍼, 마스터
        ***********************************/
        //Util.Ui.ShopUi.printShopUi;
        Scanner choice = new Scanner(System.in);
        boolean roof = true;
        while(roof){
            switch(choice.nextInt()){
                case 1: 
                    //addMedicine(),payMoney()
                    roof = false;
                    break;
                case 2: 
                    //addMonsterBall(),payMoney()
                    roof = false;
                    break;
                case 3: 
                    //addCandy(),payMoney()
                    roof = false;
                    break;
                default: 
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }
        }
        choice.close();
    }

    static public void main(String args[]){
        AdventureMap adventureMap = new AdventureMap();
        adventureMap.initMap(0);
    }
}
