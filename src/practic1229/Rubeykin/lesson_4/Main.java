package practic1229.Rubeykin.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static int[][] AIField = {{1,2,3},{4,5,6},{7,8,9}};
    public static char[][] gameField;
    public static int counterMoves = 0;
    public static int optionMove = 0;
    public static final char dot_empty = '•';
    public static final char userChar = 'o';
    public static final char AIChar = 'x';
    public static int x,y;
    public static boolean End = false, whoStep;

    public static void main(String[] args) {
        whoStep = random.nextBoolean();
        initField();
        drawsAField();
        do{
            counterMoves++;
            if (whoStep) pleerStep();
            if (!whoStep) AIStep();
            drawsAField();
            isWin();
        } while (!End);

    }

    public static void pleerStep(){
        int exit = 0;
        System.out.println("Ваш ход! Введите координаты А1 или В1 и т.д.(латинскими буквами).");
        do {
            exit = 0;
            String coordinates = sc.next();
            char[] wordCase = {'a', 'b', 'c'};
            for (int i = 0; i < 3; i++) {
                if (Character.toLowerCase(coordinates.charAt(0)) == wordCase[i]) x = i;
            }
            if (coordinates.charAt(1) == '1' || coordinates.charAt(1) == '2' || coordinates.charAt(1) == '3') {
                y = Character.getNumericValue(coordinates.charAt(1)) - 1;
                exit++;
            } else System.out.println("Вводите чила 1, 2, 3.");
            if (gameField[y][x] == dot_empty) {
                gameField[y][x] = userChar;
                AIField[y][x] = 0;
                whoStep = false;
                break;
            } else System.out.println("Эти координаты уже заняты, введите другие.");
        } while (exit != 2);
    }

    public static void AIStep(){
        if(isRivalWin(userChar)){
            whoStep = true;
        } else if (isRivalWin(AIChar)){
            whoStep = true;
        }// else doAIStep();
    }

    /*public static void doAIStep(){
        for (int i = 0; i < SIZE; i++){
            for
        }
    }*/

    public static void isWin(){
        char checkChar = ' ';
        if (whoStep) checkChar = userChar;
        if (!whoStep) checkChar = AIChar;
        int hitByHor = 0, hitByVer = 0, hitByDia1 =0, hitByDia2 = 0;
        for (int i = 0; i < gameField.length; i++){
            for (int j = 0; j < gameField.length; j++){
                if (gameField[i][j] == checkChar) hitByHor++;
                if (gameField[j][i] == checkChar) hitByVer++;
            }
            if (hitByHor == DOTS_TO_WIN || hitByVer == DOTS_TO_WIN){
                gameover();
            }
            if (gameField[i][i] == checkChar) hitByDia1++;
            if (gameField[2 - i][i] == checkChar) hitByDia2++;
            hitByHor = 0;
            hitByVer = 0;
        }
        if (hitByDia1 == DOTS_TO_WIN || hitByDia2 == DOTS_TO_WIN){
            gameover();
        }
        if (counterMoves == 9){
            System.out.println("Ничья!!!");
            End = true;
        }
    }

    public static boolean isRivalWin(char whoCheck){
        int hitByHor = 0, hitByVer = 0, hitByDia1 =0, hitByDia2 = 0;
        for (int i = 0; i < gameField.length; i++){
            for (int j = 0; j < gameField.length; j++){
                if (gameField[i][j] == whoCheck) hitByHor++;
                if (gameField[j][i] == whoCheck) hitByVer++;
            }
            if (gameField[i][i] == whoCheck) hitByDia1++;
            if (gameField[2 - i][i] == whoCheck) hitByDia2++;
            if (hitByHor == 2){
                checkHorizontal(i);
                return true;
            }
            if (hitByVer == 2){
                checkVertical(i);
                return true;
            }
            hitByHor = 0;
            hitByVer = 0;
        }
        if (hitByDia1 == 2){
            checkDiagonal(1);
            return true;
        }
        if (hitByDia2 == 2){
            checkDiagonal(2);
            return true;
        }
        return false;
    }

    public static void checkHorizontal(int j){
        for (int i = 0; i < SIZE; i++){
            if (gameField[j][i] == dot_empty) gameField[j][i] = AIChar;
        }
    }
    public static void checkVertical(int j){
        for (int i = 0; i < SIZE; i++){
            if (gameField[i][j] == dot_empty) gameField[i][j] = AIChar;
        }
    }
    public static void checkDiagonal(int j){
        if (j == 1) {
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][i] == dot_empty) gameField[j][i] = AIChar;
            }
        }
        if (j == 2){
            for (int i = 0; i < SIZE; i++) {
                if (gameField[2-i][i] == dot_empty) gameField[j][i] = AIChar;
            }
        }
    }


    public static void gameover() {
        if (whoStep) System.out.println("Победил игрок!");
        if (!whoStep) System.out.println("Победил компьютер!");
        End = true;
    }

    public static void initField(){
        gameField = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                gameField[i][j] = '•';
            }
        }
    }

    public static void drawsAField() {
        System.out.println("   A B C");
        for (int i = 0; i < SIZE; i++){
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
    }
}
