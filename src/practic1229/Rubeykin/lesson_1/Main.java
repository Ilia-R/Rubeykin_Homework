package practic1229.Rubeykin.lesson_1;

public class Main {
    // метод вычисляющий выражение a * (b + (c / d))
    public static float returnExpression(float a, float b, float c, float d){
        float result;
        result = a * (b + (c / d));
        return result;
    }
    // метод: сумма двух чисел лежит в пределах от 10 до 20 (включительно)?
    public static boolean checkSumm(int number1, int number2){
        int summ = number1 + number2;
        return summ >= 10 && summ <= 20;
    }
    // метод определяет положительное или отрицательное число.
    public static String checkSing(int number){
        if (number >= 0) return "положительное"; else return "отрицательное";
    }
    // метод определяет положительное или отрицательное число, возвращает boolean.
    public static boolean checkSingBoolean(int number){
        return number < 0;
    }
    // Написать метод, которому передается строка. Метод должен вывести сообщение «Привет, указанное_имя!».
    public static void greeting(String name){
        System.out.println("Привет, " + name + "!");
    }
    // Написать метод, который определяет, является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static String leapYear(int year){
        if (year % 4 == 0){
            if (year % 100 == 0 && year % 400 != 0) return "Год не високосный!"; else return "Год високосный!";
        }else return "Год не високосный!";
    }
    // Основная программа
    public static void main(String[] args) {

        byte byteMaxValue = 127;
        short shortMaxValue = 32767;
        int intMaxValue = 2147483647;
        long longMaxValue = 9223372036854775807L;
        float floatValue = 2.1474836f;
        double doubleValue = 9.223372036854775;
        char charValue = 'l';
        boolean booleanValue = true;
        String stringValue = "Hello, world!";

        float a = 1, b = 2, c = 3, d = 4, expression;
        expression = returnExpression(a,b,c,d);

        System.out.println(expression);
        System.out.println(checkSumm(7,7));
        System.out.println("Число " + checkSing(10));
        System.out.println(checkSingBoolean(0));
        greeting("Vasia");
        System.out.println(leapYear(37));
    }

}
