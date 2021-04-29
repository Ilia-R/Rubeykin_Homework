package practic1229.Rubeykin.lesson_11;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array1 = {"1","2","3","4","5","6"};
//        int[] array2 = {1,2,3,4,5,6,7}; не работает?
        Integer[] array2 = {1,2,3,4,5,6,7};

        swapTwoArrayElements(array1,5,2);

        List arrayList = arrayToArrayList(array1);
        System.out.println(arrayList);
        arrayList = arrayToArrayList(array2);
        System.out.println(arrayList);

        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> appleBox = new Box();
        System.out.println(apple.getWheigt());
        appleBox.addFruit(apple);
        for (int i = 0; i < 34; i++){
            appleBox.addFruit(apple);
        }
        System.out.println(appleBox.getWeight());
    }

    public static void swapTwoArrayElements (Object[] obj, int firstCell, int secondCell){
        Object box;
        box = obj[firstCell];
        obj[firstCell] = obj[secondCell];
        obj[secondCell] = box;
    }

    public static List arrayToArrayList (Object[] arrays){
        return Arrays.asList(arrays);
    }

}
