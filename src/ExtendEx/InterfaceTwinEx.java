package ExtendEx;

public class InterfaceTwinEx {

    private interface IntrA {
        int A = 10;

        void run();
    }

    private interface IntrB {
        int B = 20;
//        String A = "name"; // 구현체에서 어느 A를 써야할지 모호해짐

        void exe();

        void run();
    }

    private static class ClassEx implements IntrA, IntrB {
        @Override
        public void run() {
            System.out.println(A);
        }

        @Override
        public void exe() {
            System.out.println(B);
        }
    }

    static void main() {

        IntrA intrA = new ClassEx();

        intrA.run();

        IntrB intrB = (IntrB) intrA; //

        intrB.exe();
        intrB.run();

    }

}
