package threadEx;

public class ThreadGroupEx {

    private static class ThreadEx implements Runnable {

        static {
            System.out.println("ThreadEx 초기화");
        }

        @Override
        public void run() {

            System.out.println("부모 스레드 그룹 : " + Thread.currentThread().getThreadGroup());
            System.out.println(Thread.currentThread().getName());

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("자식 스레드 그룹 : " + Thread.currentThread().getThreadGroup());
                    System.out.println(Thread.currentThread().getName());
                }
            };

            new Thread(runnable).start();
        }
    }

    static {
        System.out.println("static : " + Thread.currentThread().getName());
        ThreadEx run = new ThreadEx();
        Thread thread = new Thread(run);
        System.out.println(Thread.currentThread().getThreadGroup());
        thread.start();
    }

    static void main() throws InterruptedException {
        Thread.sleep(2000);
//        ThreadEx run = new ThreadEx();
//
//        Thread thread = new Thread(new ThreadGroup("Temp Run"), run);
//
//        System.out.println(Thread.currentThread().getThreadGroup());
//        thread.start();

    }

}
