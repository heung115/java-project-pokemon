package Player;
import Interfaces.LevelUpUitll;

public class Player {
  private String playerName;
  private int level;
  private int exp;
  LevelUpUitll levelUpUitll = new LevelUpUitll();

  public int getLevel(){
    return level;
  }
  public String getName(){
    return playerName;
  }
  public int getExp(){
    return exp;
  }
  public void levelUp(){
    levelUpUitll.levelUp();
  }
  public Player(String playerName){
    this.playerName = playerName; 
    level = 1;
  }
}