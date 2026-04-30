package threadEx;

public class ThreadLocalEx {

    private static final ThreadLocal<String> userID = new ThreadLocal<>();

    static void main() {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();

                if (name.equals("A")) {
                    userID.set("A is good");
                } else if (name.equals("B")) {
                    userID.set("B is good");
                }

                System.out.println(name + " " + userID.get());
            }
        };

        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);

        threadA.setName("A");
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }

}
