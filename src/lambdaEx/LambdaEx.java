package lambdaEx;

public class LambdaEx {

    private interface InterA {
        void run(int a, int b);
    }

    private static void run(int a, InterA b) {
        b.run(a,a);
    }

    private static InterA exe() {
        return (x, y) -> System.out.println(x + y);
    }


    static void main() {

        run(10 ,(a, b) -> System.out.println(a * b));

        InterA exe = exe();
        exe.run(30, 20);

    }

}
