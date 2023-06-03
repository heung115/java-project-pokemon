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
    System.out.println("1. 꼬부기, 2.파이리, 3.모부기");

    while (true) {
      int input = sc.nextInt();
      switch (input) {
        case 1:
          Pokemon pokemon1 = new Pokemon(1);
          return pokemon1;
        case 2:
          Pokemon pokemon2 = new Pokemon(4);
          return pokemon2;
        case 3:
          Pokemon pokemon3 = new Pokemon(7);
          return pokemon3;
        // break;
        default:
          System.out.println("올바른 번호를 다시 입력해주세요.");
      }
    }
  }

  private void giveItem(Player player) {
    Item monsterBall = new MonsterBall("마스터볼");
    Item potion = new Potion("하급 상처약");
    Item candy = new RareCandy();
    Item nope = new Item();
    player.addItemBag(monsterBall, 30);
    player.addItemBag(potion, 5);
    player.addItemBag(candy, 1);
    player.addItemBag(nope, 1);
  }

  private void showInfo(Player player) {
    System.out.println("플레이어" + player.getName() + "이/가 생성되었습니다.");
    player.showInfo();
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
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    player.addPokemonToEncyclopedia();
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    player.addPokemonToEncyclopedia();
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    player.addPokemonToEncyclopedia();
    giveItem(player);
    showInfo(player);
    return player;
  }

}