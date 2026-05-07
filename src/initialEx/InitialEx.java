package initialEx;

public class InitialEx {

    static {
        System.out.println("initialEx init");
    }

    private static class InnerClass {
        static {
            System.out.println("hi");
        }

    }

    private class Ineer2 {

        static {
            System.out.println("hello");
        }

    }

    public static final int NUMBER = 10;

}
