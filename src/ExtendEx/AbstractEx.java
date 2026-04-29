package ExtendEx;

public class AbstractEx {

    private static abstract class ClassEx {

        abstract void exe();

        void run() {
            System.out.println("run");
        }

    }

    private static class ExClass extends ClassEx {

        @Override
        void exe() {
            System.out.println("exe");
        }
    }

    private static class ClassExe{

        protected ClassExe() { // 같은 패키지에서는 생성 가능

        }

    }

    static void main() {
        ExClass exClass = new ExClass();

        ClassExe classExe = new ClassExe();

        exClass.run();
        exClass.exe();

    }

}
