package Util;

import Player.Player;

/*
 * ui 클래스 작성 요령.
 * 각 .java파일명으로 public static class ____ { } 으로 작성
 * 내부 메소드도 STATIC으로 작성
 */
public class Ui {
    // private StringBuilder sb = new StringBuilder();

    public static class Main {
        public static void mainTitle() {
            System.out.println("===================================================");
            System.out.println("______         _                                   ");
            System.out.println("| ___ \\       | |                                  ");
            System.out.println("| |_/ /  ___  | | __  ___  _ __ ___    ___   _ __  ");
            System.out.println("|  __/  / _ \\ | |/ / / _ \\| '_ ` _ \\  / _ \\ | '_ \\ ");
            System.out.println("| |    | (_) ||   < |  __/| | | | | || (_) || | | |");
            System.out.println("\\_|     \\___/ |_|\\_\\ \\___||_| |_| |_| \\___/ |_| |_|");
            System.out.println("                                                   ");
            System.out.println("===================================================");
        }
    }
    /*
     * =============================================================================
     * =============================================================================
     */

    public static class BattleModeUi {

        public static void printBattleGameLoopUi() {
            System.out.println("=================///==================");
            System.out.println("1. 공격");
            System.out.println("2. 교체");
            System.out.println("3. 가방");
            System.out.println("4. 도망가기");
            System.out.println("=================///==================");
        }

        public static void printBattleUi(Player player, Player aiPlayer) {
            System.out.println("나 : " + player.getName());
            player.showPlayerPokemonCombat();
            System.out.println("상대 : " + aiPlayer.getName());
            aiPlayer.showPlayerPokemonCombat();
        }
    }
}