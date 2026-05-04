package CalendarEx;

import java.lang.ref.Cleaner;
import java.util.Calendar;
import java.util.Date;

public class CalendarExV3 {

    static void main() {

        Calendar timeA = Calendar.getInstance();
        Calendar timeB = Calendar.getInstance();

        timeA.set(Calendar.HOUR_OF_DAY, 10);
        timeA.set(Calendar.MINUTE, 20);
        timeA.set(Calendar.SECOND, 30);

        timeB.set(Calendar.HOUR_OF_DAY, 20);
        timeB.set(Calendar.MINUTE, 30);
        timeB.set(Calendar.SECOND, 10);

        System.out.println(timeToString(timeA));
        System.out.println(timeToString(timeB));

        timeA.add(Calendar.HOUR, 1);
        timeA.roll(Calendar.MINUTE, 50);
        System.out.println(timeToString(timeA));

        Date date = new Date(timeA.getTimeInMillis());
        System.out.println(date);

        Calendar temp = Calendar.getInstance();
        temp.setTime(date);
        System.out.println(timeToString(temp));

    }

    private static String timeToString(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.HOUR_OF_DAY))
                .append("시")
                .append(calendar.get(Calendar.MINUTE))
                .append("분")
                .append(calendar.get(Calendar.SECOND))
                .append("초");

        return sb.toString();
    }

}
