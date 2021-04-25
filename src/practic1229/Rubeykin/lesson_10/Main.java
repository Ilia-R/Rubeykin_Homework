package practic1229.Rubeykin.lesson_10;

import practic1229.Rubeykin.lesson_5.Employee;

import java.util.*;

public class Main {
    static Map<String, Integer> uniqueWords = new HashMap<>();

    public static void main(String[] args) {
        // Задание №1
        String[] template = new String[]{"apple", "orange", "banana", "pear", "peach", "orange", "apple", "apple", "banana", "apple", "banana", "apple",
                "apple", "peach", "pear", "pear", "orange", "orange", "pear", "pear"};
        ArrayList<String> words = new ArrayList<>(Arrays.asList(template));
        seach(words);
        System.out.println(uniqueWords);
       // Задание №2
        Phonebook friends = new Phonebook();
        friends.add("Ilia", new String[]{"89037770070", "8910110110"});
        friends.add("Vova", new String[]{"890335358", "82874598260"});
        friends.add("Andrew", new String[]{"80006060600"});
        friends.add("Julia", new String[]{"89037770070", "80000000000","827652876538"});
        friends.get("Ilia");
        friends.get("Julia");
        friends.get("Andrew");
    }

    public static void seach (ArrayList<String> list){
        do {
            String word = list.get(0);
            int count = 0;
            do {
                list.remove(word);
                count++;
            } while (list.contains(word));
            uniqueWords.put(word,count);
        } while (!list.isEmpty());
    }

}