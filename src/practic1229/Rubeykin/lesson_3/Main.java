package practic1229.Rubeykin.lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int numberOfAttempts = 3;
    static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static   int numberOfChecks = 0;

    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static String userWord;

    public static void main(String[] args) {

        guessNumberGame();

        char[] arrayOfletter = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        System.out.println("Угадайте какое из этих слов загадал компьютер: ");
        outputArrayOfWords(words);

        int numberOfRandomeWord = random.nextInt(words.length);
        do {
            System.out.print("Enter your word: ");
            userWord = sc.next();
            if (!words[numberOfRandomeWord].equals(userWord)) {
                if (words[numberOfRandomeWord].length() < userWord.length()) {
                    numberOfChecks = words[numberOfRandomeWord].length();
                } else numberOfChecks = userWord.length();
                for (int i = 0; i < numberOfChecks; i++) {
                    if (words[numberOfRandomeWord].charAt(i) == userWord.charAt(i)) {
                        arrayOfletter[i] = userWord.charAt(i);
                    } else arrayOfletter[i] = '#';
                }
                System.out.println(Arrays.toString(arrayOfletter));
            } else System.out.println("Поздравляю с победой!");
        } while (!words[numberOfRandomeWord].equals(userWord));

        sc.close();

    }

    public static void outputArrayOfWords (String[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    public static void guessNumberGame (){
        boolean playFurther = true;
        while (playFurther) {
            int hiddenNumber = random.nextInt(10);
            for (int i = 0; i < numberOfAttempts; i++) {
                System.out.print("Угадайте число от 0 до 9, у вас есть " + (numberOfAttempts - i) + " попытки! ");
                int guessedNumber = sc.nextInt();
                if (hiddenNumber == guessedNumber) {
                    System.out.println("Фиерично, вы угадали");
                    i = numberOfAttempts;
                } else if (guessedNumber < hiddenNumber) System.out.println("Загаданное число больше!");
                else System.out.println("Загаданное число меньше!");
            }
            System.out.println("Ещё попыточку? 1 – да / 0 – нет");
            int endOrContinue = sc.nextInt();
            if (endOrContinue == 0) playFurther = false;
        }
    }
}
