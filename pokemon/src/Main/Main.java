package Main;
import Player.*;

import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  //static Player player;

  public static Player createPlayerInstance(){
    System.out.print("플레이어의 이름 : ");
		String name = sc.next();
    Player player = new Player(name);
    return player;
  }
  public static void main(String[] args) throws Exception {

    Player player = createPlayerInstance();
    System.out.println(player.getName());
    System.out.println(player.getLevel());
  }
}
