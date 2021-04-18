package practic1229.Rubeykin.lesson_8;

public class Cat implements Act{
    private String name;
    private int distance;
    private int height;
    private boolean result;

    public Cat(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public String run(int let) {
        if (distance < let) {
            result = false;
            return name + " Не смог";
        }
        else {
            result = true;
            return name + " Cмог";
        }
    }

    @Override
    public String jump(int let) {
        if (height < let) {
            result = false;
            return name + " Не смог";
        }
        else {
            result = true;
            return name + " Смог";
        }
    }

    @Override
    public boolean isDone() {
        return result;
    }
}
