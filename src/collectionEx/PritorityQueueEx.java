package collectionEx;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PritorityQueueEx {

    final static int NEKEM = 15;
    public static void main(String[] args) {

        Comparator<Integer> cm;
        cm = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(NEKEM, cm);
        for (int i = 0; i < 10; i++) {
            queue.offer((int) (Math.random() * 100) + 1);
        }

        Iterator<Integer> iterator = queue.iterator();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    private static class ClassEx implements Comparable<ClassEx> {

        private String name;
        private Integer o1;

        @Override
        public int compareTo(ClassEx o) {

            return Integer.compare(this.o1, o.o1);
        }
    }

}
