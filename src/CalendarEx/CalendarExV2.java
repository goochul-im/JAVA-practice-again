package CalendarEx;

import java.util.Calendar;

public class CalendarExV2 {

    static void main() {

        Calendar instance = Calendar.getInstance();
        System.out.println(dateToString(instance));

    }

    private static String dateToString(Calendar calendar) {
        String[] dayOfWeek = {"", "일", "월", "화", "수", "목", "금", "토"};
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.YEAR))
                .append("년 ")
                .append(calendar.get(Calendar.MONTH) + 1)
                .append("월 ")
                .append(calendar.get(Calendar.DATE))
                .append("일 ")
                .append(dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK)])
                .append("요일")
        ;


        return sb.toString();
    }

}
