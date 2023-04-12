package Player;

import java.util.ArrayList;

public class Encyclopeoda {
  // encyclopeoda라는 2차원 동적 리스트 배열 생성
  ArrayList<ArrayList<String>> encyclopeoda = new ArrayList<ArrayList<String>>();
  // 도감 인덱스 : (포켓몬 넘버, 포켓몬 이름, hp,공격력, 속성, 설명 , 획득 여부)

  // 도감을 초기화 하는 생성자.
  public Encyclopeoda() {
    for (int i = 0; i < 10; i++) {
      ArrayList<String> temp = new ArrayList<String>();
      for (int j = 0; j < 2; j++) {
        temp.add("123");
      }
      encyclopeoda.add(temp);
    }
  }

  // 도감 출력
  public void printEncyclopeoda() {
    for (int i = 0; i < encyclopeoda.size(); i++) {
      for (int j = 0; j < encyclopeoda.get(i).size(); j++) {
        System.out.print(encyclopeoda.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
