package ThreadEx;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try {

                    String name = Thread.currentThread().getName();
                    System.out.println("Thread name : " + name);

                    Thread.sleep(1000);
                    System.out.println("Thread name : " + name + " 작업 완료.");

                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(runnable, "thread A");
        Thread thread2 = new Thread(runnable, "thread B");
        Thread thread3 = new Thread(runnable, "thread C");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("main : 작업자가 대기 ");
        latch.await();

        System.out.println("main : 작업자가 모두 끝남");
    }

}
