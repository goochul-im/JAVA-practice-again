package threadEx;

public class ThreadEx {

    static void main() {

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

    }

}
