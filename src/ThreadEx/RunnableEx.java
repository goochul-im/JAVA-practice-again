package ThreadEx;

public class RunnableEx {

    public static void main(String[] args) {
        MyCounter myCounter1 = new MyCounter("Runnable 1");
        MyCounter myCounter2 = new MyCounter("Runnable 2");

        Thread thread1 = new Thread(myCounter1);
        Thread thread2 = new Thread(myCounter2);

        thread1.start();
        thread2.start();
    }

    private static class MyCounter implements Runnable{

        private final String name;

        public MyCounter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(name + ": " + i);
            }
        }

    }

}
