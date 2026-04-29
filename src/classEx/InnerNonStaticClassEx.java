package classEx;

public class InnerNonStaticClassEx {

    static {
        System.out.println("outer init");
    }

    private int i;

    private void exe() {
        System.out.println("exe");
    }

    private static String name = "classEx";

    class InnerClass {

        static {
            System.out.println("inner init");
        }

        void method1() {
            exe();
            i = 20;
            name = "classUx"; // 탑 레벨 클래스의 name은 static이라 이미 초기화되었기에 접근 가능
        }

    }

}

