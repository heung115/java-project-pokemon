package Player;

import java.util.ArrayList;
import Pokemon.Pokemon;

public class Player {
  private String playerName;
  // private int playerState;
  private int money;
  LevelPlayer levelPlayer = new LevelPlayer();
  ArrayList<Pokemon> playerPokemon = new ArrayList<>();
  private Bag playerBag = new Bag();
  private Encyclopedia playerEncyclopedia = new Encyclopedia();

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

  public void addPokemonToPlayerPokemonArrayList() {
    Pokemon tempPokemon = new Pokemon();
    playerPokemon.add(tempPokemon);
  }

  public Player(String playerName) {
    this.playerName = playerName;
    // level = 1;
    // currentExp = 0;
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
   * for Pokemon
   */

}