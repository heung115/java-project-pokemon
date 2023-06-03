package SaveLoad;

import java.io.*;
import Player.Player;

public class Load {
    public static Player loadData() {
        try {
            FileInputStream fileIn = new FileInputStream("pokemon/src/SaveLoad/save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println("정보를 불러옵니다.");
            Player player = (Player) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("정보를 불러왔습니다.");
            int size = player.getPokemonArraySize();
            for (int i = 0; i < size; i++) {
                player.addPokemonToEncyclopediaLoad(i);
            }
            return player;
        } catch (FileNotFoundException e) {
            System.out.println("저장된 정보가 없습니다.");
            return null;
        } catch (InvalidClassException e) {
            System.out.println("저장된 파일이 버젼이 다릅니다.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
