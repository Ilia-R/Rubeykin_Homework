package practic1229.Rubeykin.lesson_11;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    public ArrayList<T> capacity;

    void addFruit (T obj){
        capacity.add(obj);
    }
    float getWeight(){
        return capacity.get(0).getWeight();
    }


}
