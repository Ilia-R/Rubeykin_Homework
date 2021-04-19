package practic1229.Rubeykin.lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void isCatEat (Plate p) {
        if (p.info() < appetite){
            satiety = false;
        }
        else {
            p.catEatFood(appetite);
            satiety = true;
        }
    }

    public String isCatSatiety(){
        if (satiety) return "Котяра " + name + " сыт";
        else return "Котэ " + name + " голоден.";
    }
}
