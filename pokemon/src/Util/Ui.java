package Util;

import Player.Player;

/*
 * ui 클래스 작성 요령.
 * 각 .java파일명으로 public static class ____ { } 으로 작성
 * 내부 메소드도 STATIC으로 작성
 */
public class Ui {
    // private StringBuilder sb = new StringBuilder();
    public static class tools {
        /*
         * 콘솔창 clear 함수.
         */
        public static void clearConsoleScreen() {
            System.out.print("\033[H\033[2J");
        }
    }

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
    public static class MainGame {
        public static void printMainGameLoopUi() {
            System.out.println("===================================");
            System.out.println("1. 배틀 모드");
            System.out.println("2. 어드벤쳐 모드");
            System.out.println("3. 옵션/정보");
            System.out.println("4. 종료");
            System.out.println("===================================");
        }
    }

    public static class BattleModeUi {

        public static void printBattleGameStartUi() {
            System.out.println("배틀 모드로 진입합니다");
            System.out.println("\n상대방 등장 \n");
        }

        public static void printBattleGameLoopUi() {
            System.out.println("===================================");
            System.out.println("1. 공격");
            System.out.println("2. 교체");
            System.out.println("3. 가방");
            System.out.println("4. 도망가기");
            System.out.println("===================================");
        }

        public static void printBattleUi(Player player, Player aiPlayer) {
            System.out.println("나 : " + player.getName());
            player.showPlayerPokemonCombat();
            System.out.println("\n상대 : " + aiPlayer.getName());
            aiPlayer.showPlayerPokemonCombat();
        }
    }

    public static class Option {
        public static void printOptionUi() {
            System.out.println("===================================");
            System.out.println("1.가방보기 \n2.플레이어 정보보기\n3.도감보기\n4.저장하기\n5.돌아가기");
            System.out.println("===================================");
        }
    }
}