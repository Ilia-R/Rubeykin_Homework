package practic1229.Rubeykin.lesson_6;

public abstract class  Animals {
    protected String name;
    protected String color;
    protected int age;
    protected static int numberCat;
    protected static int numberDog;

    public Animals(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    public abstract String swim(int a);
    public abstract String run(int a);
}
