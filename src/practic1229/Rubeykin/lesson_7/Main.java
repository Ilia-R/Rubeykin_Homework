package practic1229.Rubeykin.lesson_7;

import java.util.Scanner;

public class Main {
    public static Cat[] cat = new Cat[5];
    public static Plate plate = new Plate(23);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cat[0] = new Cat("Tom",5);
        cat[1] = new Cat("Barsik",7);
        cat[2] = new Cat("Baks",3);
        cat[3] = new Cat("Pushok",10);
        cat[4] = new Cat("Jupiter",5);
        do {
            for (Cat value : cat) value.isCatEat(plate);
            for (Cat value : cat) System.out.println(value.isCatSatiety());
            plate.leftoverFood();
            System.out.println("0 - Exit, Enter number > 0 to add food in plate.");
            int food = sc.nextInt();
            if (food != 0) plate.addFood(food); else break;
        } while (true);
        sc.close();
    }
}
