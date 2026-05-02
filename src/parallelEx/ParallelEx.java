package parallelEx;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelEx {

    public static void main(String[] args) {
        int[] numbers = new int[100_000_000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        try (ForkJoinPool pool = new ForkJoinPool()) {

            SumTask task = new SumTask(numbers, 0, numbers.length);

            long result = pool.invoke(task);

            System.out.println(result);
        }

    }

    private static class SumTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 10_000;

        private final int[] numbers;
        private final int start;
        private final int end;

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end - start;

            if (length <= THRESHOLD) { // 임계값보다 작으면 바로 계산
                return computeDirectly();
            }

            int mid = start + length / 2;
            // task 절반으로 나누기
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);
            // 작업을 자신의 큐에 넣는다
            leftTask.fork();

            long rightResult = rightTask.compute(); // 현재 스레드가 큐에 넣지 않고 바로 처리
            long leftResult = leftTask.join(); // fork한 작업의 결과를 기다린다.

            return leftResult + rightResult;
        }

        private long computeDirectly() {
            long sum = 0;

            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }

            return sum;
        }
    }

}
