package practic1229;


import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Draft_2 {
    public static void main(String[] args) {

        String simple = "hello home dad mom brothe sister";
        String[] words = simple.split(" ");
        System.out.println(Arrays.toString(words));

        /*Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println("getWeekYear() " + calendar.getWeekYear());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));*/

    }
}
