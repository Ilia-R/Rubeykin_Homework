package practic1229.Rubeykin.lesson_2;

import java.util.Arrays;

public class Main {

    // Метод к задаче №6
    public static boolean isCheckBalance(int[] arr){
        int sum = 0, left = 0;
        for (int k : arr) sum += k;
        System.out.println("Сумма всех чисел = " + sum);
        if (sum % 2 == 0){
            for (int i =0; i < arr.length; i++){
                left += arr[i];
                if (left == sum / 2){
                    System.out.println("Середина между " + (i + 1) + " & " + (i + 2) + " числами!");
                    return true;
                } if (left > sum / 2) break;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Задача №1");
        int[] arr = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == 0) arr[a] = 1;
            else arr[a] = 0;
            System.out.print(arr[a] + ", ");
        }
        System.out.println();

        System.out.println("Задача №2");
        int[] table = new int[8];
        for (int i = 0; i < table.length; i++) {
            table[i] = table[i] + i * 3;
        }
        System.out.println(Arrays.toString(table));

        System.out.println("Задача №3");
        int[] arr2 = {1, 5, 3, 2, 11, 4, 4, 8, 9};
        System.out.println("До    " + Arrays.toString(arr2));
        for (int i = 0; i < arr2.length; i++){
            if (arr2[i] < 6) arr2[i] = arr2[i] * 2;
        }
        System.out.println("После " + Arrays.toString(arr2));

        System.out.println("Задача №4");
        int[][] table2 = new int[11][11];
        for (int i = 0; i < table2.length; i++){
            table2[i][i] = 1;
            table2[i][table2.length - i - 1] = 1;
        }
        for (int[] ints : table2) {
            for (int j = 0; j < table2[table2.length - 1].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println("Задача №5");
        int max = 0;
        for (int j : arr2) {
            if (max <= j) max = j;
        }
        System.out.println(max);

        System.out.println("Задача №6");
        System.out.println("Результат проверки: " + isCheckBalance(arr2));
    }

}
