package practic1229.Rubeykin.lesson_6;

public class Cat extends Animals{

    public Cat(String name, String color, int age) {
        super(name, color, age);
        numberCat++;
    }

    @Override
    public String swim(int a) {
        return "Котэ не умеет плавать. Тем более на " + a + " метров.";
    }

    @Override
    public String run(int a) {
        if (a > 200) return "Котэ " + name + " пробежал только 200 метров из " + a + " т.к. котэ может пробежать только 200 метров.";
        else return "Котэ " + name + " пробежал " + a + " метров.";
    }
}
