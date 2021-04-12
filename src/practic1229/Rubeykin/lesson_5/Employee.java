package practic1229.Rubeykin.lesson_5;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String telephonNumber;
    private int salary;
    private int age;

    public Employee(String fio, String position, String email, String telephonNumber, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.telephonNumber = telephonNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephonNumber='" + telephonNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void information() {
        System.out.println("Ф.И.О сотрудника: " + fio);
        System.out.println("должность: " + position);
        System.out.println("email: " + email);
        System.out.println("номер телефона: " + telephonNumber);
        System.out.println("зарплата: " + salary + " возраст: " + age);
    }

}
