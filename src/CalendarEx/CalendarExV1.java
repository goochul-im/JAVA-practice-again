package CalendarEx;

import java.util.Calendar;

public class CalendarExV1 {

    static void main() {
        Calendar instance = Calendar.getInstance();

        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH) + 1);
        System.out.println(instance.get(Calendar.DATE));

        System.out.println(instance.get(Calendar.AM_PM) == 0 ? "AM" : "PM");
        System.out.println(instance.get(Calendar.HOUR));
        System.out.println(instance.get(Calendar.MINUTE));
        System.out.println(instance.get(Calendar.SECOND));
        System.out.println(instance.getActualMaximum(Calendar.MINUTE));

    }

}
