package practic1229.Rubeykin.lesson_9;

public class Main {

    public static void main(String[] args) {
        String[][] array1 = {{"1","1","1","1"},{"1","1","2","1"},{"1","1","1","1"},{"1","1","1","1"}};
        String[][] array2 = {{"1","1","1","1"},{"1","1","2","1"},{"1","1","1","1"},{"1","1","1","1","1"}};
        String[][] array3 = {{"1","1","1","1"},{"1","1","2","1"},{"1","1","1","1"},{"1","1","a","1",}};

        someTryCath(array1);
        someTryCath(array2);
        someTryCath(array3);
    }

    public static void someTryCath(String[][] array){
        try {
            arrSumm(array);
        } catch (MyArraySizeException | MyArrayDataException exception){
            System.out.println(exception.getMessage());
//            System.out.println(exception.fillInStackTrace());
        }
    }

    public static void arrSumm(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (array.length != 4){
            throw new MyArraySizeException("Не подходят размеры массива!");
        }
        for (int a = 0; a < array.length; a++){
            if (array[a].length != 4){
                throw new MyArraySizeException("Не подходят размеры массива!");
            }
        }
        for (int a = 0; a < array.length; a++){
            for (int b = 0; b <array[0].length; b++){
                try {
                    summ += Integer.parseInt(array[a][b]);
                } catch (NumberFormatException exception){
                    throw new MyArrayDataException("В ячейке [" + a + "][" + b + "] лежат неверные данные!");
                }
            }
        }
        System.out.println(summ);
    }
}
