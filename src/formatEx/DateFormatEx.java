package formatEx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx {

    static void main() {

        Date today = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(today));

        sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println(sdf.format(today));

        sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(today));

        sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss a");
        System.out.println(sdf.format(today));

        sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss a");
        System.out.println(sdf.format(today));


        sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse("2019년 11월 23일");
            System.out.println(parse);
        } catch (ParseException e) {
        }

    }

}
