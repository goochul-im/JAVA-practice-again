package ExceptionEx;

public class FinallyEx {

    static void main() {

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            System.out.println("finally start");
        }

    }

}
