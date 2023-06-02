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
            return player;
        } catch (FileNotFoundException e) {
            System.out.println("저장된 정보가 없습니다.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
