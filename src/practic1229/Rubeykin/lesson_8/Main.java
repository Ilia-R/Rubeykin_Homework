package practic1229.Rubeykin.lesson_8;

public class Main {
    public static void main(String[] args) {
        Act[] participants = new Act[10];
        participants[0] = new Human("Vasia",10,2);
        participants[1] = new Robot("R2D2",100,1);
        participants[2] = new Cat("Pushok",50,2);
        participants[3] = new Human("Bubka",1000,4);
        participants[4] = new Robot("T1000",1000,1);
        participants[5] = new Cat("Barsik",30,2);
        participants[6] = new Human("Bolt",100,2);
        participants[7] = new Robot("RoboCop",800,2);
        participants[8] = new Cat("Baks",1,5);
        participants[9] = new Human("KlarcKent",1000000,1000000);
        Lets[] lets = new Lets[10];
        lets[0] = new Wall(1);
        lets[1] = new Treadmill(10);
        lets[2] = new Wall(2);
        lets[3] = new Treadmill(100);
        lets[4] = new Wall(1);
        lets[5] = new Treadmill(50);
        lets[6] = new Wall(3);
        lets[7] = new Treadmill(1000);
        lets[8] = new Wall(4);
        lets[9] = new Treadmill(1000000);
        for (int i = 0; i < participants.length; i++){
            for (int j = 0; j < lets.length; j++){
                if (lets[j].getClass() == Wall.class){
                    System.out.println(participants[i].jump(lets[j].getValue()));
                }
                if (lets[j].getClass() == Treadmill.class){
                    System.out.println(participants[i].run(lets[j].getValue()));
                }
                if (!participants[i].isDone()) break;
            }
        }
    }
}
