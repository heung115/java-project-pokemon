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

        public static void giveDelay(int num){
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    public static class AdventureModeUi {
        public static void printShopUi() {
            System.out.println("===================================");
            System.out.println("포켓몬 상점에 오신것을 환영합니다!");
            System.out.println("===================================");
            System.out.println("1. 몬스터 볼 ");
            System.out.println("2. 상처약");
            System.out.println("3. 이상한 사탕");
            System.out.println("===================================");
            System.out.print("구매할 품목을 선택해주세요 : ");
        }
        public static void printShowItemUi(int num){
            String[] describe = new String[3];
            describe[0] = "몬스터볼 : 평범한 몬스터볼이다.(100$)\n슈퍼볼 : 포획률이 조금 높다.(150$)\n하이퍼볼 : 포획률이 상당히 높다.(300$)\n마스터볼 : 무엇이든지 잡을 수 있을것만 같다.(1000$)";
            describe[1] = "하급 상처약 : 포켓몬의 HP를 30% 회복시켜준다.(100$)\n중급 상처약 : 포켓몬의 HP를 60% 회복시켜준다.(200$)\n고급 상처약 : 포켓몬의 HP를 모두 회복시켜준다.(300$)";
            describe[2] = "이상한 사탕 : 먹으면 강해질것만 같다.(1000$)";
            System.out.println("===================================");
            System.out.println(describe[num]);
            System.out.println("===================================");
            System.out.print("구매하시겠습니까? (Y/N): ");
        }
        public static void printCannotGoUi() {
            System.out.println("더 이상 갈 수 없다.");
        }
        public static void printHealCenterUi() {
            
            try {
                Thread.sleep(500);
                System.out.println("**********************************************\n");
                System.out.println("포켓몬센터를 발견했다. 지친 포켓몬들을 쉬게 해주자.\n");
                System.out.println("**********************************************");
                Thread.sleep(700);
                for(int i =9; i>0;i--){
                    if(i%3==0) System.out.print(i/3+" ");
                    else System.out.print(". ");
                    Thread.sleep(330);
                }
                System.out.println("\n\n포켓몬들이 모두 회복되었다.\n\n");
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
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