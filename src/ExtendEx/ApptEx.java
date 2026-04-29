package ExtendEx;

public class ApptEx {

    private static class Appt{

        @Override
        public String toString() {
            return "Appt";
        }
    }

    private static class ApptCalendar{

        private final static int MAX_APPT = 1000;
        private Appt[] appts;
        private int size;

        public ApptCalendar() {
            this.appts = new Appt[MAX_APPT];
            size = 0;
        }

        public void addAppt(Appt appt) {
            if (size == appts.length) {
                return;
            }
            appts[size++] = appt;
        }

        public void addAppts(Appt[] appts) {
            for (int i = 0; i < appts.length; i++)
                addAppt(appts[i]);
        }

    }


    private static class LoggingApptCalendar extends ApptCalendar {

        @Override
        public void addAppt(Appt appt) {
            System.out.println(appt.toString());
            super.addAppt(appt);
        }

        @Override
        public void addAppts(Appt[] appts) {
            for (int i = 0; i < appts.length; i++) {
                System.out.println(appts[i].toString());
            }
            super.addAppts(appts);
        }
    }

    static void main() {
        LoggingApptCalendar loggingApptCalendar = new LoggingApptCalendar();
        loggingApptCalendar.addAppts(new Appt[] {new Appt(), new Appt(), new Appt()});
    }

}
