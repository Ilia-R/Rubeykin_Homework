package practic1229.Rubeykin.lesson_12;

public class Main {

    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        System.out.println();
        secondMethod();
    }

    public static void calculate (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        }
    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        System.out.println(arr[0]);
        long a = System.currentTimeMillis();

        calculate(arr);

        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - a));
        System.out.println(arr[0]);
    }

    public static void secondMethod() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);

        Thread t1 = new Thread(() -> {
            calculate(arr1);
        });

        Thread t2 = new Thread(() -> {
            calculate(arr2);
        });

        t1.start();
        t2.start();

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);

        System.out.println("Время работы второго метода: " + (System.currentTimeMillis() - a));
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
        System.out.println(arr[0] + " <- Какого? " + arr[HALF_SIZE]);
    }
}

