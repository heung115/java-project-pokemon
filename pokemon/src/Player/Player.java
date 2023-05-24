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
  // private LevelPlayer levelPlayer = new LevelPlayer();
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
    level++;
  }
  /*
   * for pokemon
   */

  public void showPlayerPokemonCombat() {
    Pokemon pokemon = playerPokemon.get(0);
    System.out.println(pokemon.getName());
    System.out.println("Hp :" + pokemon.getCurrentHp() + "/" + pokemon.getMaxHp());

  }

  public void showPlayerPokemon() {
    int playerPokemonSize = playerPokemon.size();

    for (int i = 0; i < playerPokemonSize; i++) {
      Pokemon tempPokemon = playerPokemon.get(i);
      tempPokemon.showAllStat();
      // TODO 포켓몬 정보 출력 부분 추가
    }
  }

  public int getPlayerPokemonMaxHp(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    return pokemon.getMaxHp();
  }

  public int getPlayerPokemonCurrentHp(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    return pokemon.getCurrentHp();
  }

  public int getPlayerPokemonDamage(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    return pokemon.getDamage();
  }

  public String getPlayerPokemonType(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    // return pokemon.getType();
    return "노말";
  }

  public String getPlayerPokemonName(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    return pokemon.getName();
  }

  public void setPlayerPokemonHp(int num, int damage) {
    Pokemon pokemon = playerPokemon.get(num);
    pokemon.setHp(damage);
  }

  public void changePokemon(int num1, int num2) {
    Collections.swap(playerPokemon, num1, num2);
  }

  public void addPokemonToPlayerPokemonArrayList(Pokemon pokemon) {
    playerPokemon.add(pokemon);
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
   */

}