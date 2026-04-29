package ArrayEx;

import EmptyEx.ExampleClass;

public class ArrayEx {

    static int f = 10;

    static {
        i = 10;
//        kkk = 20; // 대입 불가
        System.out.println(f);
//        System.out.println(b); // 접근 불가
        b = 49; // 초기화는 탑다운 순서라서 이 값은 무시됨
    }

    static int i;
    static int b = 20;

    {
        kkk = 30; // 이건 되지만, 탑다운으로 초기화되서 무시됨
//        System.out.println(kkk); // 접근 불가
    }

    int kkk = 20;

    static void main() {
        double[][] list = new double[3][];

        for (double[] doubles : list) {
            doubles = new double[4];
        }

        int[] numList = new int[]{1, 2};

        System.out.println('\u0000'); // 그냥 공백

        ExampleClass exampleClass = new ExampleClass();
//        exampleClass.name(); // 접근 불가


    }

    void run() {
        System.out.println(aaa); // 이미 초기화된 이후라서 접근 가능
        aaa = 40; // 이미 초기화된 값에 설정 가능
    }

    int aaa = 30;

}
