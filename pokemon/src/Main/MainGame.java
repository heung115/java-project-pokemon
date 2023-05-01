package Main;

import java.util.Scanner;

public class MainGame {
    Scanner scanner = new Scanner(System.in);
    private int choice = 0;

    public void mainGameLoop() {
        while (choice == 4) {
            PrintUi.printMainGameLoopUi();
            scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }

    }

}

class PrintUi {
    public static void printMainGameLoopUi() {
        System.out.println("=================///==================");
        System.out.println("1. 배틀 모드");
        System.out.println("2. 어드벤쳐 모드");
        System.out.println("3. 옵션");
        System.out.println("4. 종료");
        System.out.println("=================///==================");
    }
}