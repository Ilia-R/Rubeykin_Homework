package practic1229.Rubeykin;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    //public static int x,y;
    public static boolean End = false;
    //public static int counterMoves = 0;
    public static int[] gameField = new int[9];
    public static Random random = new Random();

    public static void main(String[] args) {
        int a = 7 % 2;
        for (int i = 0; i < 10; i++) {
            a = random.nextInt(2);
            System.out.println(a);
        }
        sc.close();
        boolean End = false;
/*        do{
            System.out.println("It's never ending story!!!");
        }while (!End);*/
    }
    public static boolean isBinaryNumber (int number){
        while(number != 0) {
            if (number % 10 != 0 && number % 10 != 1){
                System.out.println("False " + number % 10);
                return false;
            }
            number = number / 10;
        }
        return true;
    }
}
