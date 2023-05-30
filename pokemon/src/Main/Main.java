package Main;

import Player.*;
import Player.Item.*;
import Pokemon.Pokemon;
import Util.*;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import SaveLoad.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static List<List<String>> pokemonEffect = CSVReader.readCSV("pokemon/src/CVSFile/effect.csv");

  // static Player player;
  public static void main(String[] args) throws Exception {
    // main클래스 내 함수 사용위한 main객체
    Ui.tools.clearConsoleScreen();
    Main my = new Main();
    MainGame mainGame = new MainGame();
    Player player;

    System.out.println("저장되어있는 정보가 있는지 검사중입니다");
    player = Load.loadData();

    if (player != null) {
      my.showInfo(player);
    } else {
      player = my.gameStartSetting();
    }
    // Ui.Main.mainTitle();
    // Ui.tools.clearConsoleScreen();
    mainGame.mainGameLoop(player);
  }

  private Player createPlayerInstance() {
    System.out.print("플레이어의 이름 : ");
    String name = sc.next();
    Player player = new Player(name);

    return player;
  }

  // TODO: pokemon 객체 리턴타입 수정
  private Pokemon choicePokemon() {
    System.out.println("포켓몬을 고르시오");
    System.out.println("1. 파이리 ");

    int input = sc.nextInt();
    switch (input) {
      case 1:
        Pokemon pokemon = new Pokemon(1);
        return pokemon;
      case 2:
        Pokemon pokemon1 = new Pokemon(2);
        return pokemon1;
      // break;
      default:
        return null;
    }
  }

  private void giveItem(Player player) {
    Item monsterBall = new MonsterBall("몬스터볼");
    Item potion = new Potion();
    player.addItemBag(monsterBall, 3);
    player.addItemBag(potion, 5);
  }

  private void showInfo(Player player) {
    System.out.println("플레이어" + player.getName() + "이/가 생성되었습니다.");
    System.out.println("=====정보=====");
    System.out.println("이름 : " + player.getName());
    System.out.println("래벨 : " + player.getLevel() + "lv 경험치 :" + player.getCurrentExp() + "/" + player.getMaxExp());
    player.showBag();
    System.out.println("=====포켓몬=====");
    player.showPlayerPokemon();
    System.out.println("내용을 확인했으면 엔터를 눌러주세요");
    try {
      System.in.read(); // 아무 키나 누를 때까지 대기
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Player gameStartSetting() {
    Player player = createPlayerInstance();
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    player.addPokemonToEncyclopedia();
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    player.addPokemonToEncyclopedia();
    giveItem(player);
    showInfo(player);
    return player;
  }

}