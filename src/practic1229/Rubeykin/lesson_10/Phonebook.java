package practic1229.Rubeykin.lesson_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, ArrayList<String>> contact = new HashMap<>();

    public Phonebook() {

    }

    public void add (String name,String[] number) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(number));
        contact.put(name, numbers);
    }

    public void get (String name) {
        System.out.println(name + " " + contact.get(name));
    }
}
