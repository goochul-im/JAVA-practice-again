package ExtendEx;

public class FinalClassEx {

    private class NoFinal {

        void exe() {
            System.out.println("NoFinal");
        }

        final void exe2() {
            System.out.println("Final Method");
        }

    }

    private final class ClassEx {

        void exe() {
            System.out.println("exe");
        }

    }

//    private final class ExtendFinal extends ClassEx  // final 클래스는 상속이 불가

    private final class ExtendFinal extends NoFinal { // 하지만 자신이 상속받을수는 있음
        @Override
        void exe() {
            super.exe();
        }

        // 하지만 final 메소드는 오버라이드 불가
    }


}
