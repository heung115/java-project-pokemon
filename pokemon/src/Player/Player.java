package Player;

import javax.swing.border.EmptyBorder;

import Interfaces.LevelUpUtill;
import Pokemon.Pokemon;

public class Player {
  private String playerName;
  private int money;
  private Pokemon playerPokemon = new Pokemon();
  private Bag playerBag = new Bag();
  private Encyclopedia playerEncyclopedia = new Encyclopedia();

  //LevelUpUtill levelUpUitll = new LevelUpUtill();

  public String getName() {
    return playerName;
  }

  public int getMoney() {
    return money;
  }

  public void printBag() {
    System.out.println("player : bag");
    playerBag.printBag();
  }

  public Player(String playerName) {
    this.playerName = playerName;
    //level = 1;
    //currentExp = 0;

  }
}