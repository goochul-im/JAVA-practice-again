package threadEx;

import java.util.concurrent.Exchanger;

public class ExchangerEx {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();

        Thread t1 = new Thread(() -> {
            try {
                String result = exchanger.exchange("A가 보낸 데이터");
                System.out.println("A가 받은 데이터 : " + result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                String result = exchanger.exchange("B가 보낸 데이터");
                System.out.println("B가 받은 데이터 : " + result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
    }

}
