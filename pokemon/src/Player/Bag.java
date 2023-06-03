package Player;

import java.util.ArrayList;
import Player.Item.*;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class Bag implements Serializable {
    // 2차원 동적 배열
    ArrayList<ArrayList<Object>> bag = new ArrayList<>();

    public Bag() {
    }

    public void showBag() {
        if (bag.isEmpty()) {
            System.out.println("가방이 비었습니다");
        }
        System.out.print("=========가방========\n");
        System.out.print("번호  이름\t갯수\n");
        for (int i = 0; i < bag.size(); i++) {
            // System.out.print(i + ":");
            Item item = (Item) bag.get(i).get(1);
            // TODO: 한글 출력 정렬추가
            if (item.getItemIndex() == 999) {
                break;
            }
            if ((int) bag.get(i).get(2) < 1) {
                bag.remove(i);
                sortBag();
            }
            System.out.printf("%s  %s\t%3d\n", bag.get(i).get(0), item.getItemName(), bag.get(i).get(2));
            // System.out.println(item.getItemName() + "," + (int) bag.get(i).get(2) + "개");
        }
    }

    // 어쩔수 없이 아이템 객체를 리턴... 그냥 public을 써도 되지만 코드 깔끔하게 할라고 함수 작성함
    public Item useItem(int itemNum) {
        for (int i = 0; i < bag.size(); i++) {
            int choiceNum = (int) bag.get(i).get(0);
            if (choiceNum == itemNum) {
                bag.get(i).set(2, (Integer) (((int) bag.get(i).get(2)) - 1));
                // 아이템 갯수가 0이면 지운다.
                return ((Item) bag.get(i).get(1));
            }
        }
        return null;
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
        sortBag();
        for (int i = 0; i < bagSize; i++) {
            // 기존에 아이템이 있다면 itemCount만큼의 수를 늘린다.
            // TODO : 이상한사탕 못하용하면 갯수 줄어드는 문제
            if (((int) bag.get(i).get(0)) == (item.getItemIndex())) {
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
