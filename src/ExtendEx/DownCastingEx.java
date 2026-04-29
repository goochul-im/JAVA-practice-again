package ExtendEx;

public class DownCastingEx {

    private static class UpClass {

    }

    private static class DownClass extends UpClass{

        int a = 10;

        void show() {
            System.out.println("show");
        }

    }

    static void main() {

        UpClass upClass = new UpClass();
        DownClass downClass = (DownClass) upClass;

        System.out.println(downClass.a);
    }

}
