package Main;

import Player.Player;
import Player.Item.*;
import Pokemon.LevelPokemon;
import SaveLoad.Save;
import Util.Ui;
import java.util.Scanner;
import java.io.IOException;

public class Option {
    Scanner scanner = new Scanner(System.in);
    LevelPokemon levelPokemon = new LevelPokemon();
    private int choice = 0;

    public Option() {

    }

    public void mainOptionLoop(Player player) {
        while (choice != 4) {
            Ui.Option.printOptionUi();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBag(player);

                    break;
                case 2:
                    showInfo(player);
                    break;
                case 3:
                    player.ShowEncyclopedia();
                    break;
                case 4:
                    Save.savaData(player);
                    break;
                case 5:
                    return;
            }
        }
    }

    private boolean showBag(Player player) {
        player.showBag();
        System.out.println("사용할 아이템의 번호를 입력해주세요 (-1 = 돌아가기)");
        int num = scanner.nextInt();
        if (num == -1) {
            return false;
        }
        Item item = player.useItemBag(num);
        if (item == null) {
            System.out.println("다시 입력해주세요");
            showBag(player);
        }
        switch (num / 10) {
            case 1:
                // 몬스터볼
                System.out.println("사용할 수 없습니다, 다른아이템을 입력해주세요");
                player.addItemBag(item, 1);
                showBag(player);
                break;
            case 2:
                // 힐
                player.setPlayerPokemonHp(num, num);
                item.use(player);
                break;
            case 3:
                // 사탕
                player.showPlayerPokemon();
                System.out.println("사용할 포켓몬을 선택해 주세요");
                int choice = scanner.nextInt();
                choice++;
                if (player.getLevel() < player.getPlayerPokemonLevel(choice)) {
                    System.out.println("이포켓몬에는 사용할 수 없다");
                    player.addItemBag(item, 1);
                    showBag(player);
                } else {
                    player.levelUpPlayerPokemon(1, choice);
                    System.out.println("렙업 완료!!!");
                    player.showPlayerPokemon();
                }
        }
        return false;
    }

    private void showInfo(Player player) {
        player.showInfo();
        System.out.println("내용을 확인했으면 엔터를 눌러주세요");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
