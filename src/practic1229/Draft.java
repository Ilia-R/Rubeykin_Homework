package practic1229;

import java.util.Random;
import java.util.Scanner;

public class Draft {

    public static final char dot_empty = '•';
    public static final char userChar = 'o';
    public static final char AIChar = 'x';
    public static final String[] player = {"Сакйнет","Кожанный ублюдок"};
    public static int counter;
    public static int[] binaryNumberArr = new int[9];
    public static int[][] gameField = new int[2][9];
    public static int[] options = new int[512];
    public static int[] optionsForMove = new int[127];
    public static int[] winningCombinations = new int[99];
    public static int[] statistic = new int[9];
    public static boolean End = false;

    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        counter = random.nextInt(2);
        for (int i = 1; i <= 512; i++) options[i-1] = i;
        removesUnwantedNumbersFromOptions();
        zeroingBinaryArray();
        packOptionsForMove(5);
        searchForWinningCombinations();
        for (int i = 0; i < binaryNumberArr.length; i++) binaryNumberArr[i] = 0;
        drawsAField();
        do {
            int k = 0;
            if (counter % 2 == 1) getCoordinates(counter % 2);
            if (counter % 2 == 0){
                if (isFastMove(1));
                else if (isFastMove(0));
                else {
                    if (gameField[1][4] != 1 && gameField[0][4] != 1) gameField[0][4] = 1;
                    else if (gameField[1][0] != 1 && gameField[0][0] != 1) gameField[0][0] = 1;
                    else if (gameField[1][2] != 1 && gameField[0][2] != 1) gameField[0][2] = 1;
                    else if (gameField[1][6] != 1 && gameField[0][6] != 1) gameField[0][6] = 1;
                    else if (gameField[1][8] != 1 && gameField[0][8] != 1) gameField[0][8] = 1;
                    else if (gameField[1][1] != 1 && gameField[0][1] != 1) gameField[0][1] = 1;
                    else if (gameField[1][3] != 1 && gameField[0][3] != 1) gameField[0][3] = 1;
                    else if (gameField[1][5] != 1 && gameField[0][5] != 1) gameField[0][5] = 1;
                    else if (gameField[1][7] != 1 && gameField[0][7] != 1) gameField[0][7] = 1;
                }
            }
            if (isWeHaveAWinner(counter % 2)) { drawsAField(); break;}
            drawsAField();
            for (int i = 0; i < 9; i++){
                k = k + gameField[0][i] + gameField [1][i];
            }
            if (k == 9) break;
            counter++;
        } while (!End);
        if (isWeHaveAWinner(counter % 2)) System.out.println("Игра закончена победил " + player[counter % 2]);
        else System.out.println("I'll be back");
        /*for (int i = 0; i < statistic.length; i++) {
            System.out.print(statistic[i] + " ");
            if ((i + 1) % 3 == 0) System.out.println();
        }*/
        sc.close();
    }

    public static void getCoordinates(int a){
        int b = 9;
        System.out.print("Сейчас ходит: " + player[counter % 2] +". Введите координаты a1 или b1 и т.д.(латинскими буквами): ");
        String coordinates;
        do {
            coordinates = sc.nextLine();
            if (coordinates.equals("a1")) b = 0;
            else if (coordinates.equals("a2")) b = 3;
            else if (coordinates.equals("a3")) b = 6;
            else if (coordinates.equals("b1")) b = 1;
            else if (coordinates.equals("b2")) b = 4;
            else if (coordinates.equals("b3")) b = 7;
            else if (coordinates.equals("c1")) b = 2;
            else if (coordinates.equals("c2")) b = 5;
            else if (coordinates.equals("c3")) b = 8;
            else System.out.println("Попробуйте ещё раз. Формат: а1,а2,а3,в1,в2,в3,с1,с2,с3.");
            if (b != 9 && gameField[a][b] != 1) gameField[a][b] = 1;
            //drawsAField();
        } while (b == 9);
    }
    public static void decimalToBinary(int a) {
        int i = 0, b;
        while (a != 0) {
            b = a % 2;
            binaryNumberArr[i] = b;
            i++;
            a = a / 2;
        }
    }
    public static void leftShiftArr(int a){
        for (int i = a; i < options.length; i++){
            if (options[i] == 512) break;
            options[i] = options[i + 1];
        }
    }
    public static void removesUnwantedNumbersFromOptions(){
        for (int i = 0; i < options.length; i++){
            int numbersOfOne = 0;
            if (options[i] != 512) {
                decimalToBinary(options[i]);
                for (int j = 0; j < binaryNumberArr.length; j++) {
                    if (binaryNumberArr[j] == 1) numbersOfOne++;
                }
                if (numbersOfOne > 5){
                    leftShiftArr(i);
                    i--;
                }
            }
        }
    }

    public static void searchForWinningCombinations(){
        int i = 0, j = 0;
        packOptionsForMove(5);
        do {
            decimalToBinary(optionsForMove[i]);
            if (binaryNumberArr[0] == 1 && binaryNumberArr[3] == 1 && binaryNumberArr[6] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[0]++; statistic[3]++; statistic[6]++;
                j++;
            } else if (binaryNumberArr[1] == 1 && binaryNumberArr[4] == 1 && binaryNumberArr[7] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[1]++; statistic[4]++; statistic[7]++;
                j++;
            } else if (binaryNumberArr[2] == 1 && binaryNumberArr[5] == 1 && binaryNumberArr[8] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[2]++; statistic[5]++; statistic[8]++;
                j++;
            }else if (binaryNumberArr[0] == 1 && binaryNumberArr[1] == 1 && binaryNumberArr[2] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[0]++; statistic[1]++; statistic[2]++;
                j++;
            }else if (binaryNumberArr[3] == 1 && binaryNumberArr[4] == 1 && binaryNumberArr[5] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[3]++; statistic[4]++; statistic[5]++;
                j++;
            }else if (binaryNumberArr[6] == 1 && binaryNumberArr[7] == 1 && binaryNumberArr[8] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[6]++; statistic[7]++; statistic[8]++;
                j++;
            }else if (binaryNumberArr[0] == 1 && binaryNumberArr[4] == 1 && binaryNumberArr[8] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[0]++; statistic[4]++; statistic[8]++;
                j++;
            }else if (binaryNumberArr[2] == 1 && binaryNumberArr[4] == 1 && binaryNumberArr[6] == 1) {
                if (winningCombinations[j] != optionsForMove[i]) winningCombinations[j] = optionsForMove[i];
                statistic[2]++; statistic[4]++; statistic[6]++;
                j++;
            }
            i++;
        } while (optionsForMove[i] != 512);
        winningCombinations[j] = 512;
    }

    public static void zeroingBinaryArray(){
        for (int i = 0; i < binaryNumberArr.length; i++) binaryNumberArr[i] = 0;
    }

    public static void packOptionsForMove(int a){
        int b = 0;
        for (int i = 0; i < options.length; i++){
            int numbersOfOne = 0;
            if (options[i] != 512) {
                decimalToBinary(options[i]);
                for (int j = 0; j < binaryNumberArr.length; j++) {
                    if (binaryNumberArr[j] == 1) numbersOfOne++;
                }
                zeroingBinaryArray();
                if (numbersOfOne == a){
                    optionsForMove[b] = options[i];
                    optionsForMove[b + 1] = 512;
                    b++;
                }
            }
        }
    }
    public static void drawsAField() {
        System.out.println("   A B C");
        for (int i = 0; i < 9; i++){
            if (i == 3 || i == 6) System.out.println();
            if (i == 0 || i == 3 || i == 6) System.out.print(" " + ((i + 3) / 3) + " ");
            if (gameField[0][i] == 1) System.out.print(AIChar + " ");
            else if (gameField[1][i] == 1) System.out.print(userChar + " ");
            else System.out.print(dot_empty + " ");
        }
        System.out.println();
    }
    public static boolean isFastMove (int a){
        int b;
        if (a == 0) b = 1; else b = 0;
        if (gameField[a][0] + gameField[a][1] + gameField[a][2] == 2){
            if (gameField[a][0] == 0 && gameField[b][0] == 0) {gameField[0][0] = 1; return true;}
            if (gameField[a][1] == 0 && gameField[b][1] == 0) {gameField[0][1] = 1; return true;}
            if (gameField[a][2] == 0 && gameField[b][2] == 0) {gameField[0][2] = 1; return true;}
        }
        if (gameField[a][3] + gameField[a][4] + gameField[a][5] == 2){
            if (gameField[a][3] == 0 && gameField[b][3] == 0) {gameField[0][3] = 1; return true;}
            if (gameField[a][4] == 0 && gameField[b][4] == 0) {gameField[0][4] = 1; return true;}
            if (gameField[a][5] == 0 && gameField[b][5] == 0) {gameField[0][5] = 1; return true;}
        }
        if (gameField[a][6] + gameField[a][7] + gameField[a][8] == 2){
            if (gameField[a][6] == 0 && gameField[b][6] == 0) {gameField[0][6] = 1; return true;}
            if (gameField[a][7] == 0 && gameField[b][7] == 0) {gameField[0][7] = 1; return true;}
            if (gameField[a][8] == 0 && gameField[b][8] == 0) {gameField[0][8] = 1; return true;}
        }
        if (gameField[a][0] + gameField[a][3] + gameField[a][6] == 2){
            if (gameField[a][0] == 0 && gameField[b][0] == 0) {gameField[0][0] = 1; return true;}
            if (gameField[a][3] == 0 && gameField[b][3] == 0) {gameField[0][3] = 1; return true;}
            if (gameField[a][6] == 0 && gameField[b][6] == 0) {gameField[0][6] = 1; return true;}
        }
        if (gameField[a][1] + gameField[a][4] + gameField[a][7] == 2){
            if (gameField[a][1] == 0 && gameField[b][1] == 0) {gameField[0][1] = 1; return true;}
            if (gameField[a][4] == 0 && gameField[b][4] == 0) {gameField[0][4] = 1; return true;}
            if (gameField[a][7] == 0 && gameField[b][7] == 0) {gameField[0][7] = 1; return true;}
        }
        if (gameField[a][2] + gameField[a][5] + gameField[a][8] == 2){
            if (gameField[a][2] == 0 && gameField[b][2] == 0) {gameField[0][2] = 1; return true;}
            if (gameField[a][5] == 0 && gameField[b][5] == 0) {gameField[0][5] = 1; return true;}
            if (gameField[a][8] == 0 && gameField[b][8] == 0) {gameField[0][8] = 1; return true;}
        }
        if (gameField[a][0] + gameField[a][4] + gameField[a][8] == 2){
            if (gameField[a][0] == 0 && gameField[b][0] == 0) {gameField[0][0] = 1; return true;}
            if (gameField[a][4] == 0 && gameField[b][4] == 0) {gameField[0][4] = 1; return true;}
            if (gameField[a][8] == 0 && gameField[b][8] == 0) {gameField[0][8] = 1; return true;}
        }
        if (gameField[a][2] + gameField[a][4] + gameField[a][6] == 2){
            if (gameField[a][2] == 0 && gameField[b][2] == 0) {gameField[0][2] = 1; return true;}
            if (gameField[a][4] == 0 && gameField[b][4] == 0) {gameField[0][4] = 1; return true;}
            if (gameField[a][6] == 0 && gameField[b][6] == 0) {gameField[0][6] = 1; return true;}
        }
        return false;
    }
    public static boolean isWeHaveAWinner (int a){
        if (gameField[a][0] + gameField[a][1] + gameField[a][2] == 3) return true;
        else if (gameField[a][3] + gameField[a][4] + gameField[a][5] == 3) return true;
        else if (gameField[a][6] + gameField[a][7] + gameField[a][8] == 3) return true;
        else if (gameField[a][0] + gameField[a][3] + gameField[a][6] == 3) return true;
        else if (gameField[a][1] + gameField[a][4] + gameField[a][7] == 3) return true;
        else if (gameField[a][2] + gameField[a][5] + gameField[a][8] == 3) return true;
        else if (gameField[a][0] + gameField[a][4] + gameField[a][8] == 3) return true;
        else if (gameField[a][2] + gameField[a][4] + gameField[a][6] == 3) return true;
        else return false;
    }
    /*public static void logicalMove(int[] arr){
        for (int i = 0; i < )

    }*/
}
