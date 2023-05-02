
import Player.*;

import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  //static Player player;

  private Player createPlayerInstance() {
    System.out.print("플레이어의 이름 : ");
    String name = sc.next();
    Player player = new Player(name);
    return player;
  }

  // TODO: pokemon 객체 리턴타입 수정
  private void choicePokemon() {

  }

  // TODO: give item 작성
  private void giveItem() {

  }

  public Player gameStartSetting() {
    Player player = createPlayerInstance();
    choicePokemon();
    giveItem();
    return player;
  }

  public static void mainGame() {
    while (true) {
      int mainNum = sc.nextInt();
      System.out.println("뭘 할건가요?");
      System.out.println("1. 탐험");
      System.out.println("2. 전투");
      System.out.println("3. 옵션");
      switch (mainNum) {
        case 1:

          break;
        case 2:

          break;
        case 3:

          break;
        default:
          System.out.println("다시 입력하세요");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // main클래스 내 함수 사용위한 main객체
    // Main my = new Main();
    // Player player = my.gameStartSetting();

    //System.out.println(player.getName());

  }
}