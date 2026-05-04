package collectionEx;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class EnumSetEx {

    private enum WeekDay{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        {
            System.out.println("AAA");
        }

        void run() {
            System.out.println(this.toString());
        }

    }

    public static void main(String[] args) {
        Set<WeekDay> es = EnumSet.of(WeekDay.SUNDAY, WeekDay.MONDAY);
        EnumSet<WeekDay> all = EnumSet.allOf(WeekDay.class);

//        WeekDay.valueOf();
        WeekDay.SUNDAY.run();

        Iterator<WeekDay> iterator = es.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        Iterator<WeekDay> iteratorall = all.iterator();
        while (iteratorall.hasNext())
            System.out.println(iteratorall.next());

    }

}
