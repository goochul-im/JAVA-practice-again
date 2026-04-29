package EmptyEx;

public class EmptyEx {

    static void main() {

        int i = Integer.MIN_VALUE;

        ExampleClass exampleClass = new ExampleClass();
        exampleClass.name = "hi"; // 접근 가능, 변경도 가능

        System.out.println(i >> 0b111111);

    }

    private void run(Double ...values) {
        for (Double value : values) {
            System.out.println(value);
        }
    }

}
