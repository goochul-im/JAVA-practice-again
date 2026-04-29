package classEx;

public class LocalClassEx {

    void method1() {

        int i = 10;
        int j = 20;
        class LocalClass{
            int x = 30;
            int y = 40;
        }
        LocalClass localClass = new LocalClass();

        System.out.println(localClass.x);
        System.out.println(localClass.y);

    }

    void method2() {
//        new LocalClass() // 스코프가 달라서 안됨
    }

    static interface ClassInterface{ // 암시적으로 static이 됨 (지금은 중복)

    }

    static void main() {
        LocalClassEx localClassEx = new LocalClassEx();
        localClassEx.method1();
    }

}
