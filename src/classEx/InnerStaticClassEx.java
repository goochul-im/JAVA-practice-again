package classEx;

public class InnerStaticClassEx {

    static {
        System.out.println("outerClass Initialize");
    }

    private static int i = 10;

    private static void method1() {
        System.out.println("method1");
    }

    public static void method2() {
        System.out.println("method2");
    }

    public static class InnerStatic{

        static {
            System.out.println("InnerStatic initialize");
        }

        static void m1() {
            System.out.println("m1");
            method1();
//            m2(); // m2는 static이 아니라서 m1보다 나중에 초기화됨
        }

        void m2() {
            System.out.println("m2");
            method2();
            m1();
        }

    }

    static void main() {
        InnerStaticClassEx classEx = new InnerStaticClassEx();

        InnerStaticClassEx.InnerStatic.m1();

        InnerStatic innerStatic = new InnerStatic();
        innerStatic.m2();
    }

}
