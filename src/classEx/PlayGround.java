package classEx;

public class PlayGround {

    private static void change(String s) {
        s = "is changed";
    }

    private interface InterA {

        int add() throws Exception;

        default int minus() {
            System.out.println("minus");
            return 0;
        }

    }

    private interface InterB{

        int add();

        default int minus() {
            System.out.println("new minus");
            return 1;
        }

    }

    private abstract class classNEx {

        public static final String myStatic = "gi";

        public classNEx(){

        }


    }

    private class classEx implements InterA, InterB {
        @Override
        public int add() {
            return 0;
        }

        @Override
        public int minus() {
            return InterA.super.minus();
        }
    }

    static interface A {
        int X = init();

        static int init() {
            System.out.println("A init");
            return 1;
        }

//        default void run() {
//            System.out.println("run");
//        }
    }

    static {
        B.i = 100;
        B.j = 200;
        System.out.println(B.i);
        System.out.println(B.j);
        kkk = 300;
    }

    static int kkk = 100;

    static class B implements A {

        static int i = 100;
        static int j = init();

        static {
            System.out.println("B init");
        }

        static int init() {
            return 100;
        }
    }

    static String ss;

    public static void main(String[] args) {

        String old = "old one";
        change(old);
        System.out.println(old);

        System.out.println(classNEx.myStatic);

        new B();

        A.init();

        System.out.println(ss);
    }

}
