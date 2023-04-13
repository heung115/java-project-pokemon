package Player;

import Interfaces.LevelUpUtill;
import Pokemon.Pokemon;

public class Player {
  private String playerName;
  private int level;
  private int currentExp;
  private int maxExp;
  private int money;
  private Pokemon playerPokemon = new Pokemon();
  private Bag playerBag = new Bag();

  LevelUpUtill levelUpUitll = new LevelUpUtill();

  public int getLevel() {
    return level;
  }

  public String getName() {
    return playerName;
  }

  public int getMaxExp() {
    return maxExp;
  }

  public int getMoney() {
    return money;
  }

  public int setExp(int changeAmountExp) {
    this.currentExp += changeAmountExp;
    return currentExp;
  }

  public void levelUp() {
    levelUpUitll.levelUp();
  }

  public void printBag() {
    System.out.println("player : bag");
    playerBag.printBag();
  }

  public Player(String playerName) {
    this.playerName = playerName;
    level = 1;
    currentExp = 0;

  }
}