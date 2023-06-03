package Player;

import java.util.List;
import java.io.*;
import Util.CSVReader;

public class Encyclopedia implements Serializable {
  // Encyclopedia 2���� ���� ����Ʈ �迭 ����
  public static List<List<String>> encyclopedia = CSVReader
      .readCSV("pokemon/src/CVSFile/Encyclopedia.csv");
  // ���� �ε��� : (���ϸ� �ѹ�, ȹ�濩��, ���ϸ� �̸�, hp,���ݷ�, �Ӽ�, ���� , ȹ�� ����)

  // ������ �ʱ�ȭ �ϴ� ������.a
  public Encyclopedia() {

  }

  // ���� ���
  public void ShowEncyclopedia() {
    for (int i = 0; i < encyclopedia.get(0).size(); i++) {
      if (i == 1) {
        continue;
      }
      System.out.printf("%-15s", encyclopedia.get(0).get(i));
    }
    System.out.println();

    for (int i = 1; i < encyclopedia.size(); i++) {
      System.out.printf("%-15s", encyclopedia.get(i).get(0));
      for (int j = 1; j < encyclopedia.get(i).size(); j++) {
        if (j == 1) {
          continue;
        }
        if (Boolean.parseBoolean(encyclopedia.get(i).get(1)) == true) {
          System.out.printf("%-15s", encyclopedia.get(i).get(j));
        } else {
          System.out.printf("%-15s", "??");
        }
      }
      System.out.println();
    }
  }

  public void addPokemonToEncyclopedia(int pokemonNum) {
    encyclopedia.get(pokemonNum).set(1, "true");
  }
}
