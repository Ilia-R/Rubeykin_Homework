package practic1229.Rubeykin.lesson_7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void catEatFood(int n) {
        if (n <= food) food -= n;
    }
    public int info() {
        return food;
    }
    public void addFood(int a){
        food += a;
    }
    public void leftoverFood(){
        System.out.println("В миске есть " + food + " кг еды.");
    }

}
