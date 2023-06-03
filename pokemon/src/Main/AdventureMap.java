package Main;

import java.util.List;
import java.util.Scanner;

import Player.Encyclopedia;
import Player.Player;
import Player.Item.*;
import Pokemon.*;
import Util.*;

public class AdventureMap {
    public AdventureMap() {
    }

    private Scanner scanner = new Scanner(System.in);
    private List<List<String>> mapList = CSVReader.readCSV("pokemon/src/CVSFile/map.csv");
    private String selectedMap[] = new String[80];
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

    public boolean move(Player player, int mapNumber, int key) {
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
                    event(player, place);
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
                    event(player, place);
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
                    event(player, place);
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
                    event(player, place);
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

    private void event(Player player, String place) {
        switch (place) {
            case "B":
                Util.Ui.tools.clearConsoleScreen();
                bush(player);
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

    private void bush(Player player) {

        int size = Encyclopedia.encyclopedia.size();
        double a = Math.random();

        if (a > 0.5) {
            Pokemon wildPokemon = new Pokemon(Pokemon.makeRandom(size, true));
            LevelPokemon.giveLevel(wildPokemon, (int)(a*100%player.getLevel())+5);;
            System.out.println("************************************************");
            System.out.println("야생의 " + wildPokemon.getName() + "가 나타났다!");
            System.out.println("************************************************");
            battleLoop(player, wildPokemon);

        } else {
            printMap(selectedMap);
        }

        return;
    }

    private void healCenter(Player player) {
        Ui.AdventureModeUi.printHealCenterUi();
        for (int i = 0; i < player.getPokemonArraySize(); i++) {
            player.setPlayerPokemonHp(i, -99999);
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
            System.out.println("\n잔액 : " + player.getMoney() + "$");
            Util.Ui.AdventureModeUi.printShopUi();

            switch (choice.nextInt()) {
                case 1:// 몬스터볼
                    Ui.AdventureModeUi.printShowItemUi(0);
                    buyItem(player, 1);
                    break;
                case 2:// 상처약
                    Ui.AdventureModeUi.printShowItemUi(1);
                    buyItem(player, 2);
                    break;
                case 3:// 이상한사탕
                    Ui.AdventureModeUi.printShowItemUi(2);
                    buyItem(player, 3);
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

    private void buyItem(Player player, int itemNum) {
        Scanner choice = new Scanner(System.in);
        boolean roof = true;
        int num1, num2;

        while (roof) {
            roof = false;
            switch (choice.next()) {
                case "Y":
                case "y":
                    System.out.print("구입할 물품을 입력해주세요 : ");
                    num1 = choice.nextInt();
                    System.out.print("구입할 갯수를 입력해주세요 : ");
                    num2 = choice.nextInt();
                    purchase(player, itemNum, num1, num2);// 볼구매
                    return;
                case "N":
                case "n":
                    System.out.println("\n구입을 취소하였습니다.");
                    Ui.tools.giveDelay(500);
                    return;
                default:
                    roof = true;
                    System.out.print("\n입력 오류! 다시 입력해주세요 : ");
                    break;
            }

        }
        choice.close();
        return;
    }

    private void purchase(Player player, int itemNum, int num1, int num2) {
        /******************************************
         * 몬스터볼 : 100$, 150$, 300$, 1000$
         * 상처약 : 100$, 200$, 300$
         * 이상한사탕 : 1000$
         ******************************************/
        int itemPrice = 0;

        Item potion = new Item();
        Item monsterBall = new Item();
        Item candy = new Item();

        switch (itemNum) {
            case 1:
                switch (num1) {
                    case 1:
                        itemPrice = 100;
                        monsterBall = new MonsterBall("몬스터볼");
                        break;
                    case 2:
                        itemPrice = 150;
                        monsterBall = new MonsterBall("슈퍼볼");
                        break;
                    case 3:
                        itemPrice = 300;
                        monsterBall = new MonsterBall("하이퍼볼");
                        break;
                    case 4:
                        itemPrice = 1000;
                        monsterBall = new MonsterBall("마스터볼");
                        break;
                    default:
                        throw new IllegalArgumentException("유효하지 않은 품목입니다.");

                }
                break;
            case 2:
                switch (num1) {
                    case 1:
                        itemPrice = 100;
                        potion = new Potion("하급 상처약");
                        break;
                    case 2:
                        itemPrice = 200;
                        potion = new Potion("중급 상처약");
                        break;
                    case 3:
                        itemPrice = 300;
                        potion = new Potion("고급 상처약");
                        break;
                    default:
                        throw new IllegalArgumentException("유효하지 않은 품목입니다.");
                }
                break;
            case 3:
                itemPrice = 1000;
                candy = new RareCandy();
                break;
        }

        if (player.gerMoney() >= (itemPrice * num2)) {
            player.setMoney(-itemPrice * num2);
            switch (itemNum) {
                case 1:
                    player.addItemBag(monsterBall, num2);
                    break;
                case 2:
                    player.addItemBag(potion, num2);
                    break;
                case 3:
                    player.addItemBag(candy, num2);
                    break;
            }
            System.out.println("\n아이템 " + num2 + "개를 구입하였습니다.\n");
            Ui.tools.giveDelay(1000);
        } else {
            System.out.println("\n돈이 부족합니다.\n");
            Ui.tools.giveDelay(1000);
        }

    }

    /*
     * for battle
     */
    private double circulateEffect(String type1, String type2) {
        int type = -1;
        int pokemonEffectSize = Main.pokemonEffect.size();
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type1.equals(Main.pokemonEffect.get(i).get(0))) {
                type = i;
                break;
            }
        }
        if (type == -1) {
            System.out.println("타입을 찾을 수 없습니다");
            return -1.0;
        }
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type2.equals(Main.pokemonEffect.get(0).get(i))) {
                double effect = Double.parseDouble(Main.pokemonEffect.get(type).get(i));
                if (effect == 1.25) {
                    System.out.println("효과과 굉장했다..");
                } else if (effect == 1) {
                    System.out.println("효과는 평범했다..");
                } else if (effect == 0.8) {
                    System.out.println("효과과 굉장했다..");
                }
                return effect;
            }
        }
        return -10.0;
    }

    private double circulateDamageFormula(Player player, Pokemon pokemon) {
        double typeDamage = circulateEffect(player.getPlayerPokemonType(0), pokemon.getType());
        return player.getPlayerPokemonDamage(0) * typeDamage;
    }

    private double circulateDamageFormulaPokemon(Player player, Pokemon pokemon) {
        double typeDamage = circulateEffect(pokemon.getType(), player.getPlayerPokemonType(0));
        return pokemon.getDamage() * typeDamage;
    }

    private boolean attack(Player player, Pokemon pokemon) {
        int damage = (int) circulateDamageFormula(player, pokemon);
        pokemon.setHp(damage);
        System.out.println(
                player.getName() + "의 포켓몬 " + player.getPlayerPokemonName(0) + "이/가 " + damage + "만큼의 공격 성공\n");
        if (pokemon.getCurrentHp() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean attackPokemon(Player player, Pokemon pokemon) {
        int damage = (int) circulateDamageFormulaPokemon(player, pokemon);
        player.setPlayerPokemonHp(0, damage);
        System.out.println(pokemon.getName() + "이/가 " + damage + "만큼의 공격 성공\n");
        if (player.getPlayerPokemonCurrentHp(0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void printBattleUi(Player player, Pokemon pokemon) {
        System.out.println("나 : " + player.getName());
        player.showPlayerPokemonCombat();
        System.out.println("\n상대 : " + pokemon.getName());
        System.out.println("Level :" + pokemon.getLevel());
        System.out.println("Hp :" + pokemon.getCurrentHp() + "/" + pokemon.getMaxHp());
    }

    private void changePokemon(Player player) {
        player.showPlayerPokemon();
        System.out.println("바꿀 두 포켓몬의 번호를 입력하시오. (뒤로가기 : -1)");
        int num1 = scanner.nextInt();
        if (num1 == -1) {
            System.out.println("전투중에 한눈을 팔았다....");
            return;
        }
        int num2 = scanner.nextInt();
        player.changePokemon(num1 - 1, num2 - 1);
        System.out.println("포켓몬이 교체되었습니다.\n");
    }

    private void run(Player player) {
        System.out.println("도망쳤다!!\n");
    }

    private boolean bag(Player player, Pokemon pokemon) {
        player.showBag();
        System.out.println("사용할 아이템의 번호를 입력해주세요 (-1 = 돌아가기)");
        int num = scanner.nextInt();
        if (num == -1) {
            System.out.println("전투중에 한눈을 팔았다....");
            return false;
        }
        Item item = player.useItemBag(num);
        if (item == null) {
            System.out.println("다시 입력해주세요");
            bag(player, pokemon);
        }
        switch (num / 10) {
            case 1:
                // 몬스터볼
                System.out.println("몬스터터볼 사용");
                int temp = player.getPokemonArraySize();
                // System.out.println(player.useItemBag(num).getItemName());
                item.use(player, pokemon);

                if (temp != player.getPokemonArraySize()) {
                    Ui.tools.giveDelay(500);
                    return true;
                }
                break;
            case 2:
                // 힐
                item.use(player);
                break;
            case 3:
                // 사탕
                System.out.println("사용할 수 없습니다, 다른아이템을 입력해주세요");
                player.addItemBag(item, 1);
                bag(player, pokemon);
        }
        return false;
    }

    private void reward(Player player) {
        int playerExp = 10;
        int pokemonExp = 10;
        System.out.println("포켓몬을 죽였다");
        System.out.println(player.getName() + "이/가" + playerExp + "만큼의경험치 획득\n");
        player.setExp(playerExp);
        System.out.println(player.getPlayerPokemonName(0) + "이/가" + pokemonExp + "만큼의경험치 획득\n");
        player.giveExpPlayerPokemon(pokemonExp, 0);
    }

    private void battleLoop(Player player, Pokemon pokemon) {
        int choice;
        while (true) {
            printBattleUi(player, pokemon);
            Ui.AdventureModeUi.printBattleLoopUi();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (attack(player, pokemon)) {
                        reward(player);
                        return;
                    }

                    break;
                case 2:
                    changePokemon(player);
                    break;
                case 3:
                    if (bag(player, pokemon)) {
                        return;
                    }
                    break;
                case 4:
                    run(player);
                    return;
            }
            if (attackPokemon(player, pokemon)) {
                // TODO 죽었다
            }
        }

    }
}
