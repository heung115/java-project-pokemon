package Interfaces;

interface LevelUpUInterface {
  public void levelUp();
}

public class LevelUpUtill implements LevelUpUInterface {
  public void levelUp() {
    System.out.print("level up");
  }

}
