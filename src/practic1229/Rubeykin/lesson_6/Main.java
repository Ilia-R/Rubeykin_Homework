package practic1229.Rubeykin.lesson_6;

public class Main {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom", "grey",8);
        Cat lom = new Cat("Lom", "grey",8);
        Cat zom = new Cat("Zom", "grey",8);
        Dog bobik = new Dog("Bobik","brown",6);
        System.out.println(tom.run(100));
        System.out.println(tom.run(500));
        System.out.println(tom.swim(10));
        System.out.println(bobik.run(200));
        System.out.println("Всего котов: " + Animals.numberCat);
        System.out.println("Всего собак: " + Animals.numberDog);
        System.out.println("Всего животин: " + (Animals.numberCat + Animals.numberDog));

    }
}
