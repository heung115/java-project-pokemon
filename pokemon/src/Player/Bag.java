package Player;

import java.util.ArrayList;
import Player.Item.*;
import java.util.Collections;
import java.util.Comparator;

public class Bag {
  // 2차원 동적 배열
  ArrayList<ArrayList<Object>> bag = new ArrayList<>();

  public Bag() {
  }

  public void showBag() {
    if (bag.isEmpty()) {
      System.out.println("가방이 비었습니다");
    }
    for (int i = 0; i < bag.size(); i++) {
      System.out.print(i + ":");
      Item item = (Item) bag.get(i).get(1);
      System.out.println(item.getItemName() + "," + (int) bag.get(i).get(2) + "개");
      System.out.println();
    }
  }

  public void useItem(int itemNum) {

  }

  /*
   * 가방에서의 아이템 인덱스
   * 중요!!! 아이템 매개변수를 넘길 때 업캐스팅해서 넘겨야함!!!!!!!
   * 아이템 인덱스
   * 아이템 객체
   * 아이템 수
   */
  public void addItem(Item item, int itemCount) {
    int bagSize = bag.size();
    for (int i = 0; i < bagSize; i++) {
      if (((Item) bag.get(i).get(1)).getItemName().equals(item.getItemName())) {
        bag.get(i).set(2, ((Integer) bag.get(i).get(2)).intValue() + itemCount);
        sortBag();
        return;
      }
    }
    ArrayList<Object> row = new ArrayList<>();
    row.add(item.getItemIndex());
    row.add(item);
    row.add(itemCount);
    bag.add(row);
    sortBag();
  }

  private void sortBag() {
    Collections.sort(bag, Comparator.comparingInt(row -> (int) row.get(0)));
  }
}
