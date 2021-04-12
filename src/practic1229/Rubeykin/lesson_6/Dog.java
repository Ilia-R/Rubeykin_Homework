package practic1229.Rubeykin.lesson_6;

public class Dog extends Animals{
    public Dog(String name, String color, int age) {
        super(name, color, age);
        numberDog++;
    }

    @Override
    public String swim(int a) {
        if (a <= 10) return "Собакен " + name + " проплых " + a + " метров.";
        else return "Это собакен, а не ихтиандр. Поэтому проплыл 10 метров вместо " + a;
    }

    @Override
    public String run(int a) {
        if (a < 500) return "Собакен " + name + " пробежал " + a + " метров и хочет пробежать ещё " + (500 - a) + " метров.";
        else if (a == 500) return "Собакен " + name + " пробежал ровно 500 метров и доволен этим.";
        else return name + " не бегает более 500 метров, поэтому " + (a - 500) + " метров оставил на птом.";
    }
}
