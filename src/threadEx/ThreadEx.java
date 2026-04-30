package threadEx;

public class ThreadEx {

    static void main() throws InterruptedException {

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("child Thread is run");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("main thread");

        thread.join();

        System.out.println("main end");

    }

}
