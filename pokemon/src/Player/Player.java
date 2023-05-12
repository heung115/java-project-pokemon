package Player;

import java.util.ArrayList;
import java.util.Collections;
import Pokemon.Pokemon;

public class Player {
  private String playerName;
  // private int playerState;
  private int money;
  LevelPlayer levelPlayer = new LevelPlayer();
  private ArrayList<Pokemon> playerPokemon = new ArrayList<>();
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
    // return pokemon.getDamage();
    return 100;
  }

  public String getPlayerPokemonType(int num) {
    Pokemon pokemon = playerPokemon.get(num);
    // return pokemon.getType();
    return "노말";
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
    Pokemon tempPokemon = playerPokemon.get(playerPokemon.size());
    playerEncyclopedia.addPokemonToEncyclopedia(tempPokemon.getPokemonNumber());
  }
  /*
   * 
   */

}