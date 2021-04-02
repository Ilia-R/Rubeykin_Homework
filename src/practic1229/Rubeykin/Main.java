package practic1229.Rubeykin;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int x,y;
    public static boolean End = false;
    public static int counterMoves = 0;


    public static void main(String[] args) {
        do {
            step();
            if (counterMoves == 9) End = true;
        } while (!End);
    }

    public static void step(){
        x = 4;
        y = 4;
        System.out.print("Ваш ход введите координаты: ");
        do {
            String coordinates = sc.next();
            char[] wordCase = {'a', 'b', 'c'};
            for (int i = 0; i < 3; i++) {
                if (Character.toLowerCase(coordinates.charAt(0)) == wordCase[i]) x = i;
            }
            if (coordinates.charAt(1) == '1' || coordinates.charAt(1) == '2' || coordinates.charAt(1) == '3')
                y = Character.getNumericValue(coordinates.charAt(1)) - 1;
            if ((x == 0 || x == 1 || x == 2) && (y == 0 || y == 1 || y == 2)) {
                counterMoves++;
                System.out.println("x= " + x + ", y= " + y + ", counterMoves= " + counterMoves);
                break;
            } else System.out.println("Вводите данные в формате a1, b2, c3 и т.д.");
            if (x == 2 && y == 2) End = true;
        } while (true);
    }
}
