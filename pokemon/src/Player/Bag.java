package Player;

import java.util.ArrayList;

public class Bag {
  // 2차원 동적 배열
  ArrayList<ArrayList<Integer>> bag = new ArrayList<ArrayList<Integer>>();

  public Bag() {
    for (int i = 0; i < 10; i++) {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      for (int j = 0; j < 2; j++) {
        temp.add(0);
      }
      bag.add(temp);
    }
  }

  public void showBag() {
    for (int i = 0; i < bag.size(); i++) {
      for (int j = 0; j < bag.get(i).size(); j++) {
        System.out.print(bag.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  public void useItem(int itemNum) {

  }

  public void addItem(int itemNum, int itemCount) {

  }
}
