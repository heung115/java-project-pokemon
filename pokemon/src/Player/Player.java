package Player;

import java.util.ArrayList;
import java.util.Collections;
import Pokemon.Pokemon;

public class Player {
  private String playerName;
  // private int playerState;
  private int money;
  LevelPlayer levelPlayer = new LevelPlayer();
  ArrayList<Pokemon> playerPokemon = new ArrayList<>();
  private Bag playerBag = new Bag();
  private Encyclopedia playerEncyclopedia = new Encyclopedia();

  public Player(String playerName) {
    this.playerName = playerName;
    // level = 1;
    // currentExp = 0;
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

  /*
   * for pokemon
   */
  public void printPlayerPokemon() {
    for (int i = 0; i < playerPokemon.size(); i++) {
      Pokemon tempPokemon = playerPokemon.get(i);
      tempPokemon.showAllStat();
      // TODO 포켓몬 정보 출력 부분 추가
    }
  }

  public void changePokemon(int num1, int num2) {
    Collections.swap(playerPokemon, num1, num2);
  }

  public void addPokemonToPlayerPokemonArrayList() {
    Pokemon tempPokemon = new Pokemon();
    playerPokemon.add(tempPokemon);
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
    Pokemon tempPokemon = playerPokemon.get(playerPokemon.size());
    playerEncyclopedia.addPokemonToEncyclopedia(tempPokemon.getPokemonNumber());
  }
  /*
   * 
   */

}