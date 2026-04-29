package ExtendEx;

public class InterfaceEx {

    private interface IntrA {
        static int a = 0;
        final int b = 10;

        void run();

        default void exe() {
            System.out.println("exe");
        }

    }

    private static class ClassEx implements IntrA {
        @Override
        public void run() {
            System.out.println(b);
        }
    }

    static void main() {
        ClassEx classEx = new ClassEx();

        new IntrA() {

            @Override
            public void run() {

            }

            @Override
            public void exe() {
                IntrA.super.exe();
            }
        }.exe();

        classEx.run();

    }

}
