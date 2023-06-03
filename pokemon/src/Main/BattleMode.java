package Main;

import Player.Player;
import Player.Item.*;
import Player.AiPlayer;
import Pokemon.Pokemon;
import Util.Ui;

import java.util.Scanner;

public class BattleMode {
    private int choice = 0;
    Scanner scanner = new Scanner(System.in);
    Player aiPlayer = makeAiPlayer(0);

    public BattleMode() {

    }

    public void mainBattleModeLoop(Player player) {
        Ui.tools.clearConsoleScreen();
        Ui.BattleModeUi.printBattleGameStartUi();
        Player aiPlayer = makeAiPlayer(0);
        choice = 0;
        while (choice != 4) {
            Ui.BattleModeUi.printBattleUi(player, aiPlayer);
            Ui.BattleModeUi.printBattleGameLoopUi();
            choice = scanner.nextInt();
            Ui.tools.clearConsoleScreen();
            switch (choice) {
                case 1:
                    // 죽이면 true리턴
                    if (attack(player, aiPlayer)) {
                        // ai가 사용가능한 포켓몬으로 변경..
                        // 나중에 플레이어 클래스에서 자동으로 가장 좋은 포켓몬 가져오는 로직을 구성해도 좋을듯
                        System.out.println("상대방의 포켓몬이 쓰려졌다.\n");
                        if (((AiPlayer) aiPlayer).aiPlayerCanUsePokemon() != -1) {
                            aiPlayer.changePokemon(0, ((AiPlayer) aiPlayer).aiPlayerCanUsePokemon());
                            continue;
                        } 
                        else if(){}
                        else {
                            // ai플레이어 전투 종료...
                            giveReward(player);
                            System.out.println("win!!");
                            aiPlayer = makeAiPlayer(0);
                            return;
                        }
                    }
                    break;
                case 2:
                    changePokemon(player);
                    break;
                case 3:
                    bag(player);
                    break;
                case 4:
                    run(player);
                    return;
            }

            // ai 플레이어가 공격
            if (attack(aiPlayer, player)) {
                // 보상 추가
            }
        }
    }

    /*
     * for choice battle
     */
    private double circulateEffect(String type1, String type2) {
        int type = -1;
        int pokemonEffectSize = Main.pokemonEffect.size();
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type1.equals(Main.pokemonEffect.get(i).get(0))) {
                type = i;
                break;
            }
        }
        if (type == -1) {
            System.out.println("타입을 찾을 수 없습니다");
            return -1.0;
        }
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type2.equals(Main.pokemonEffect.get(0).get(i))) {
                double effect = Double.parseDouble(Main.pokemonEffect.get(type).get(i));
                if (effect == 1.25) {
                    System.out.println("효과가 굉장했다..");
                } else if (effect == 1) {
                    System.out.println("효과는 평범했다..");
                } else if (effect == 0.8) {
                    System.out.println("효과가 별로였다..");
                }
                return effect;
            }
        }
        return -10.0;
    }

    private double circulateDamageFormula(Player player1, Player player2) {
        double typeDamage = circulateEffect(player1.getPlayerPokemonType(0), player2.getPlayerPokemonType(0));
        return player1.getPlayerPokemonDamage(0) * typeDamage;
    }

    private boolean attack(Player player1, Player player2) {
        int damage = (int) circulateDamageFormula(player1, player2);
        player2.setPlayerPokemonHp(0, damage);
        System.out.println(
                player1.getName() + "의 포켓몬 " + player1.getPlayerPokemonName(0) + "이/가 " + damage + "만큼의 공격 성공\n");
        if (player2.getPlayerPokemonCurrentHp(0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void changePokemon(Player player) {
        player.showPlayerPokemon();
        System.out.println("바꿀 두 포켓몬의 번호를 입력하시오.(뒤로가기 : -1)");
        int num1 = scanner.nextInt();
        if (num1 == -1) {
            System.out.println("전투중에 한눈을 팔았다....");
            return;
        }
        int num2 = scanner.nextInt();
        player.changePokemon(num1 - 1, num2 - 1);
        
    }

    private void run(Player player) {
        System.out.println("도망쳤다!!");
    }

    /*
     * for win reward
     */
    private void giveReward(Player player) {
        Item rareCandy = new RareCandy();
        int moneyAmount = 100;
        int expAmount = 11;
        player.setMoney(moneyAmount);
        player.addItemBag(rareCandy, 1);
        System.out.println(moneyAmount + "의 돈과 이상한사탕 1개를 얻었다. \n " + expAmount + "만큼의 경험치를 획득하였다.");
        player.setExp(expAmount);
    }

    /*
     * for choice bag
     */
    private void bag(Player player) {
        player.showBag();
        System.out.println("사용할 아이템의 번호를 입력해주세요 (-1 = 돌아가기)");
        int num = scanner.nextInt();
        if (num == -1) {
            System.out.println("전투중에 한눈을 팔았다....");
            return;
        }
        if (num / 10 != 2) {
            System.out.println("사용할 수 없습니다, 다른아이템을 입력해주세요");
            bag(player);
        } else {
            (player.useItemBag(num)).use(player);
        }

    }

    /*
     * for Ai
     */

    private Player makeAiPlayer(int aiPlayerLevel) {
        Player aiPlayer = new AiPlayer("Ai");
        for (int i = 0; i < 3; i++) {
            // TODO: 나중에 인자로 플레이어 랩 넘기기
            aiPlayer.addPokemonToPlayerPokemonArrayList(makeAiPlayerPokemon(i + 2));
            aiPlayer.giveExpPlayerPokemon(aiPlayerLevel * 10, i);
        }
        return aiPlayer;
    }

    private Pokemon makeAiPlayerPokemon(int levelNum) {
        // TODO: levelNum에 따라서 생성되면 포켓몬 변경로직 작성
        Pokemon pokemon = new Pokemon(levelNum);
        // pokemon.makePokemon(levelNum);
        return pokemon;
    }
}
