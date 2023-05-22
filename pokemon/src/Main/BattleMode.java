package Main;

import Player.Player;
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
        while (choice != 4) {
            // TODO ai 전투 과정 만들기
            Ui.BattleModeUi.printBattleUi(player, aiPlayer);
            Ui.BattleModeUi.printBattleGameLoopUi();
            // showAiPokemon();
            choice = scanner.nextInt();
            Ui.tools.clearConsoleScreen();
            switch (choice) {
                case 1:
                    // 죽이면 true리턴
                    if (attack(player, aiPlayer)) {
                        // ai가 사용가능한 포켓몬으로 변경..
                        // 나중에 플레이거 클래스에서 자동으로 가장 좋은 포켓몬 가져오느 로직을 구성해도 좋을듯
                        System.out.println("ai pokemon dead");
                        if (((AiPlayer) aiPlayer).aiPlayerCanUsePokemon() != -1) {
                            aiPlayer.changePokemon(0, ((AiPlayer) aiPlayer).aiPlayerCanUsePokemon());
                        } else {
                            // ai플레이어 전투 종료...
                            // 보상지금..
                            System.out.println("win!!");
                        }

                        // ai 턴 넘기기
                        continue;
                    }
                    if (attack(aiPlayer, player)) {

                        // 보상 추가

                    }
                    break;
                case 2:
                    changePokemon(player);
                    break;
                case 3:

                    break;
                case 4:
                    run(player);
                    break;
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
        for (int i = 1; i < pokemonEffectSize; i++) {
            if (type2.equals(Main.pokemonEffect.get(0).get(i))) {
                return Double.parseDouble(Main.pokemonEffect.get(type).get(i));
            }
        }
        return -1.0;
    }

    private double circulateDamageFormula(Player player1, Player player2) {
        double typeDamage = circulateEffect(player1.getPlayerPokemonType(0), player2.getPlayerPokemonType(0));
        return player1.getPlayerPokemonDamage(0) * typeDamage;
    }

    private boolean attack(Player player1, Player player2) {
        int damage = (int) circulateDamageFormula(player1, player2);
        player2.setPlayerPokemonHp(0, damage);
        System.out.println(
                player1.getName() + "의 포켓몬 " + player1.getPlayerPokemonTName(0) + "이/가 " + damage + "만큼의 공격 성공");
        if (player2.getPlayerPokemonCurrentHp(0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void changePokemon(Player player) {
        player.showPlayerPokemon();
        System.out.println("바꿀 두 포켓몬을 선택하시오.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        player.changePokemon(num1, num2);
    }

    private void run(Player player) {
        System.out.println("run!!");
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
