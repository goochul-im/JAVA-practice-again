package threadEx;

import java.util.ArrayList;
import java.util.Arrays;

public class SyncExV1 {

    private static class Customer implements Runnable {

        private Table table;
        private String food;

        public Customer(Table table, String food) {
            this.table = table;
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                String name = Thread.currentThread().getName();
                table.remove(food);
                System.out.printf("%s ate a %s\n",name,food);
            }
        }
    }

    private static class Cook implements Runnable {

        private Table table;

        public Cook(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            while (true) {
                int idx = (int) (Math.random() * table.dishNum());
                table.add(table.dishName[idx]);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private static class Table {

        String[] dishName = {"donut", "donut", "burger"};
        final int MAX_FOOD = 6;
        private ArrayList<String> dishes = new ArrayList<>();

        public synchronized void add(String dish) { // 동기화 메소드
            while (dishes.size() >= MAX_FOOD) { // 이미 준비된 음식의 양이 최댓값보다 크거나 많다면
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try {
                    wait(); // 이 메소드를 호출한 cook 스레드는 대기한다
                    Thread.sleep(500); // 꺠어나면 500ms 대기
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            dishes.add(dish);
            System.out.println("Cooking : " + dish);
            notify();
            System.out.println("dishes : " + dishes.toString());
        }

        public void remove(String dishName) {
            synchronized (this) {
                String name = Thread.currentThread().getName();

                while (dishes.size() <= 0) {
                    System.out.println(name + "is waiting");
                    try {
                        wait();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }

                while (true) {
                    for (int i = 0; i < dishes.size(); i++) {
                        if (dishName.equals(dishes.get(i))) {
                            dishes.remove(i);
                            notify(); // 잠자고 있던 cook 스레드 깨움
                            return;
                        }
                    }

                    // 위에서 원하던 dishName을 찾았을 경우, 얼리 리턴
                    // 못찾으면 아래까지 내려가서 wait를 하게 됨.
                    try {
                        System.out.println(name + "is waiting");
                        wait();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }

        public int dishNum() {
            return this.dishName.length;
        }
    }

    static void main() throws InterruptedException {

        Table table = new Table();

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"), "CUSTOMER1").start();
        new Thread(new Customer(table, "burger"), "CUSTOMER2").start();

        Thread.sleep(2000);
//        System.exit(0);
    }

}
