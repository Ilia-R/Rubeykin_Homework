package practic1229.Rubeykin.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random randomNumber = new Random();
        Scanner scannerNumber = new Scanner(System.in);
        boolean playFurther = true;
        while (playFurther) {
            int hiddenNumber = randomNumber.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.print("Угадайте число от 0 до 9, у вас есть " + (3 - i) + " попытки! ");
                int guessedNumber = scannerNumber.nextInt();
                if (hiddenNumber == guessedNumber) {
                    System.out.println("Фиерично, вы угадали");
                    i = 3;
                } else if (guessedNumber < hiddenNumber) System.out.println("Загаданное число больше!");
                else System.out.println("Загаданное число меньше!");
            }
            System.out.println("Ещё попыточку? 1 – да / 0 – нет");
            int endOrContinue = scannerNumber.nextInt();
            if (endOrContinue == 0) playFurther = false;
       }
        scannerNumber.close();
    }
}
