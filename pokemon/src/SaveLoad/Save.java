package SaveLoad;

import java.io.*;
import Player.Player;

public class Save {

    public static void savaData(Player player) {
        try {
            FileOutputStream fileOut = new FileOutputStream("pokemon/src/SaveLoad/save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.println("player 객체가 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
