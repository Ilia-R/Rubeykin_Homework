package practic1229.Rubeykin.lesson_5;

public class Main {

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Петров Петр Петрович", "разнорабрчий", "ppp@gmail.ru", "false", 1000,44);
        persArray[1] = new Employee("Иванов Иван Иванович","монтажник","iii@gmail.ru","bulubulu",10000,32);
        persArray[2] = new Employee("Сидоров Сидор Сидорович", "охранник", "sss@gmail.ru", "900", 10000, 68);
        persArray[3] = new Employee("Эйс Вентура Петрушкович","PR манагер","toice@yandex.ru","03", 100000,35);
        persArray[4] = new Employee("Змей Горыныч Кощеевич","ген. дир.","to_hell@mail.ru","Apple", 1500000,307);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) persArray[i].information();
        }
    }

}
