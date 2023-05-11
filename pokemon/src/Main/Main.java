package Main;

import Player.*;
import Pokemon.Pokemon;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  // static Player player;
  public static void main(String[] args) throws Exception {
    // main클래스 내 함수 사용위한 main객체

    Main my = new Main();
    Player player = my.gameStartSetting();
    MainGame mainGame = new MainGame();
    player.showPlayerPokemon();
    // my.mainTitle();

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
    Pokemon pokemon = new Pokemon();
    int input = sc.nextInt();
    switch (input) {
      case 1:
        pokemon.makePokemon(1);
        return pokemon;
      case 2:
        break;
      default:
        return pokemon;
    }
    return pokemon;
  }

  // TODO: give item 작성
  private void giveItem() {

  }

  private void showInfo(Player player) {

  }

  public Player gameStartSetting() {
    Player player = createPlayerInstance();
    player.addPokemonToPlayerPokemonArrayList(choicePokemon());
    giveItem();
    showInfo(player);
    return player;
  }

  /*
   * show UI
   */
  private void mainTitle() {
    System.out.println("===================================================");
    System.out.println("______         _                                   ");
    System.out.println("| ___ \\       | |                                  ");
    System.out.println("| |_/ /  ___  | | __  ___  _ __ ___    ___   _ __  ");
    System.out.println("|  __/  / _ \\ | |/ / / _ \\| '_ ` _ \\  / _ \\ | '_ \\ ");
    System.out.println("| |    | (_) ||   < |  __/| | | | | || (_) || | | |");
    System.out.println("\\_|     \\___/ |_|\\_\\ \\___||_| |_| |_| \\___/ |_| |_|");
    System.out.println("                                                   ");
    System.out.println("===================================================");
  }

}