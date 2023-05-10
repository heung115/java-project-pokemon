package Player;

import java.util.List;

import Util.CSVReader;

public class Encyclopedia {
  // Encyclopedia 2차원 동적 리스트 배열 생성
  public static List<List<String>> encyclopedia = CSVReader
      .readCSV("/Users/kimhyungho/java-project-pokemon/pokemon/src/CVSFile/Encyclopedia.csv");
  // 도감 인덱스 : (포켓몬 넘버, 포켓몬 이름, hp,공격력, 속성, 설명 , 획득 여부)

  // 도감을 초기화 하는 생성자.a
  public Encyclopedia() {

  }

  // 도감 출력
  public void ShowEncyclopedia() {
    for (int i = 0; i < encyclopedia.get(0).size(); i++) {
      if (i == 1) {
        continue;
      }
      System.out.printf("%15s", encyclopedia.get(0).get(i));
    }
    System.out.println();

    for (int i = 1; i < encyclopedia.size(); i++) {
      System.out.printf("%15s", encyclopedia.get(i).get(0));
      for (int j = 1; j < encyclopedia.get(i).size(); j++) {
        if (j == 1) {
          continue;
        }
        if (Boolean.parseBoolean(encyclopedia.get(i).get(1)) == true) {
          System.out.printf("%15s", encyclopedia.get(i).get(j));
        } else {
          System.out.printf("%15s", "??");
        }
      }
      System.out.println();
    }
  }

  public void addPokemonToEncyclopedia(int pokemonNum) {

  }
}
