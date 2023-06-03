package Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import Pokemon.Pokemon;
import Player.Item.*;

public class Player implements Serializable {
  private String playerName;
  // private int playerState;
  private int money;
  private int level;
  private int currentExp;
  private int maxExp;

  protected int availableCombatPokemonCount = 3;
  ArrayList<Pokemon> playerPokemon = new ArrayList<>();
  private Bag playerBag = new Bag();
  private Encyclopedia playerEncyclopedia = new Encyclopedia();

  public Player(String playerName) {
    this.playerName = playerName;
    level = 1;
    currentExp = 0;
    maxExp = 10;
  }

  public String getName() {
    return playerName;
  }

  public int getMoney() {
    return money;
  }

  public void printBag() {
    System.out.println("player : bag");
    playerBag.showBag();
  }

  public void showInfo() {
    System.out.println("=====정보=====");
    System.out.println("이름 : " + getName());
    System.out.println("래벨 : " + getLevel() + "\nlv 경험치 :" + getCurrentExp() + "/" + getMaxExp());
    showBag();
    System.out.println("=====포켓몬=====");
    showPlayerPokemon();
  }
  /*
   * for pokemon
   */

  public void showPlayerPokemonCombat() {
    Pokemon pokemon = playerPokemon.get(0);
    System.out.println(pokemon.getName());
    // System.out.println("level :" + pokemon.getLevel);
    System.out.println("Hp :" + pokemon.getCurrentHp() + "/" + pokemon.getMaxHp());
  }

  public void showPlayerPokemon() {
    int playerPokemonSize = playerPokemon.size();

    for (int i = 0; i < playerPokemonSize; i++) {
      System.out.print((i + 1) + ". ");
      Pokemon tempPokemon = playerPokemon.get(i);
      tempPokemon.showAllStat();
    }
  }

  public int getPlayerPokemonMaxHp(int num) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      return pokemon.getMaxHp();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return -1;
    }
  }

  public int getPlayerPokemonCurrentHp(int num) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      return pokemon.getCurrentHp();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return -1;
    }
  }

  public int getPlayerPokemonDamage(int num) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      return pokemon.getDamage();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return -1;
    }
  }

  public String getPlayerPokemonType(int num) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      return pokemon.getType();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return "-1";
    }

  }

  public String getPlayerPokemonName(int num) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      return pokemon.getName();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return "-1";
    }
  }

  public void setPlayerPokemonHp(int num, int damage) {
    try {
      Pokemon pokemon = playerPokemon.get(num);
      pokemon.setHp(damage);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 포켓몬을 선택해주세요.");
      return;
    }

  }

  public void changePokemon(int num1, int num2) {
    try {
      Collections.swap(playerPokemon, num1, num2);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("알맞은 범위의 수를 입력해주세요.");
    }
  }

  public void addPokemonToPlayerPokemonArrayList(Pokemon pokemon) {
    playerPokemon.add(pokemon);
  }

  public int getPokemonArraySize() {
    return playerPokemon.size();
  }

  public void giveExpPlayerPokemon(int exp, int pokemonNum) {

  }

  /*
   * for Encyclopedia
   */
  public void ShowEncyclopedia() {
    playerEncyclopedia.ShowEncyclopedia();
  }

  public void addPokemonToEncyclopedia() {
    Pokemon tempPokemon = playerPokemon.get(playerPokemon.size() - 1);
    System.out.println(tempPokemon.getName() + "를 도감에 등록합니다");
    playerEncyclopedia.addPokemonToEncyclopedia(tempPokemon.getPokemonNumber());
  }

  /*
   * for Bag
   */
  public Item useItemBag(int num) {
    return playerBag.useItem(num);
  }

  public void addItemBag(Item item, int num) {
    playerBag.addItem(item, num);
  }

  public void showBag() {
    playerBag.showBag();
  }

  /*
   * for player level
   * 래벨은 경험치가 10, 20 , 30 ... 이런식으로 늘어남
   */

  public int getLevel() {
    return level;
  }

  public int getCurrentExp() {
    return currentExp;
  }

  public int getMaxExp() {
    return maxExp;
  }

  public int setExp(int exp) {
    currentExp += exp;
    if (currentExp > maxExp) {
      levelUp();
      currentExp = maxExp - currentExp;
      maxExp = level * 10;

    }
    return currentExp;
  }

  private void levelUp() {
    System.out.print("레밸업!! " + level + "->");
    level++;
    System.out.println(level);

  }

  /*
   * for player Money
   */
  public int gerMoney() {
    return money;
  }

  public void setMoney(int amount) {
    money += amount;
  }
}