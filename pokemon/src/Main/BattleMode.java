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

                        System.out.println(aiPlayer.getPlayerPokemonName(0) + "이/거 쓰려졌다.\n");

                        if (((AiPlayer) aiPlayer).aiPlayerCanUsePokemon() != -1) {
                            aiPlayer.changePokemon(0, ((AiPlayer) aiPlayer).aiPlayerCanUsePokemon());
                            continue;
                        } else {
                            // ai플레이어 전투 종료...
                            giveReward(player);
                            System.out.println("대전에서 승리했다!!\n");
                            // aiPlayer = makeAiPlayer(0);
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

                if (player.getPlayerPokemonCurrentHp(0) == 0) {
                    if (player.getLiveCombatPokemonCount() == 1) {
                        System.out.println("대전에서 패배했다..\n");
                        System.out.println("눈앞이 깜깜해 진다..\n");
                        Ui.tools.giveDelay(500);
                        System.out.println("포켓몬이 모두 치유되었습니다.\n");
                        Ui.tools.giveDelay(500);
                        for (int i = 0; i < player.getPokemonArraySize(); i++) {
                            player.setPlayerPokemonHp(i, -99999);
                        }
                        player.setLiveCombatPokemonCount();
                        return;
                    } else {
                        System.out.println(player.getPlayerPokemonName(0) + "이 쓰려졌다.\n");
                        player.decreaseLiveCombatPokemonCount(1);
                        System.out.println(player.getLiveCombatPokemonCount());
                        Boolean boolean_ = false;
                        while (true) {
                            System.out.println("교체할 포켓몬을 선택하세요.\n");
                            player.showPlayerPokemon();
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                case 2:
                                case 3:
                                    break;
                                default:
                                    System.out.println("다시 입력해주세요.\n");
                                    boolean_ = true;
                                    continue;
                            }
                            if (boolean_)
                                continue;
                            if (player.getPlayerPokemonCurrentHp(choice - 1) == 0)
                                System.out.println("선택할 수 없습니다.\n");
                            else {
                                player.changePokemon(0, choice - 1);
                                break;
                            }
                        }
                    }
                }
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
        // System.out.println("포켓몬이 교체되었습니다.");
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
        Ui.tools.clearConsoleScreen();
        return aiPlayer;
    }

    private Pokemon makeAiPlayerPokemon(int levelNum) {
        Pokemon pokemon = new Pokemon(Pokemon.makeRandom(9, true));
        // pokemon.makePokemon(levelNum);
        return pokemon;
    }
}
