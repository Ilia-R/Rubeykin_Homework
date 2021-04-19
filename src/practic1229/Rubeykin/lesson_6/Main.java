package practic1229.Rubeykin.lesson_6;

public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[10];
        animals[0] = new Cat("John","green",11);
        animals[1] = new Dog("Butch","Fuxi",15);
        Cat tom = new Cat("Tom", "grey",8);
        Cat lom = new Cat("Lom", "grey",8);
        Cat zom = new Cat("Zom", "grey",8);
        Dog bobik = new Dog("Bobik","brown",6);
        System.out.println(animals[0].name);
        System.out.println(tom.run(100));
        System.out.println(tom.run(500));
        System.out.println(tom.swim(10));
        System.out.println(bobik.run(200));
        System.out.println("Всего котов: " + Animals.numberCat);
        System.out.println("Всего собак: " + Animals.numberDog);
        System.out.println("Всего животин: " + (Animals.numberCat + Animals.numberDog));

    }
}
