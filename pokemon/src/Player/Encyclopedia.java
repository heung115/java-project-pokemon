package Player;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.io.*;
import Util.CSVReader;

public class Encyclopedia implements Serializable {
    // Encyclopedia 2차원 동적 리스트 배열 생성
    public static List<List<String>> encyclopedia = CSVReader
            .readCSV("pokemon/src/CVSFile/Encyclopedia.csv");
    // 도감 인덱스 : (포켓몬 넘버, 획득여부, 포켓몬 이름, hp,공격력, 속성, 설명 , 획득 여부)

    // 도감을 초기화 하는 생성자.a
    public Encyclopedia() {

    }

    // 도감 출력
    public void ShowEncyclopedia() {
        for (int i = 0; i < encyclopedia.get(0).size(); i++) {
            if (i == 1) {
                continue;
            }
            if (encyclopedia.get(0).get(i).length() > 3) {
                System.out.printf("%s\t", encyclopedia.get(0).get(i));
            } else {
                System.out.printf("%s\t\t", encyclopedia.get(0).get(i));
            }
        }
        System.out.println();

        for (int i = 1; i < encyclopedia.size(); i++) {
            System.out.printf("%s\t\t", encyclopedia.get(i).get(0));
            for (int j = 1; j < encyclopedia.get(i).size(); j++) {
                if (j == 1) {
                    continue;
                }
                if (Boolean.parseBoolean(encyclopedia.get(i).get(1)) == true) {
                    if (encyclopedia.get(i).get(j).length() > 3 && containsHangul(encyclopedia.get(i).get(j))) {
                        System.out.printf("%s\t", encyclopedia.get(i).get(j));
                    } else {
                        System.out.printf("%s\t\t", encyclopedia.get(i).get(j));
                    }
                } else {
                    System.out.printf("%s\t\t", "??");
                }
            }
            System.out.println();
        }
    }

    private static boolean containsHangul(String input) {
        // 한글 유니코드 범위: \uAC00-\uD7A3
        Pattern pattern = Pattern.compile(".*[\\p{IsHangul}]+.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void addPokemonToEncyclopedia(int pokemonNum) {
        encyclopedia.get(pokemonNum).set(1, "true");
    }
}
