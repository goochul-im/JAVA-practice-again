package ExtendEx;

import java.util.ArrayList;
import java.util.List;

public class SuperEx {

    private static enum MyEnum{
        NEW
    }

    private static class A{

    }

    private static class B extends A{

    }

    private static class MyClass<T>{

    }

    private static <T extends A> void run(T item) {
        System.out.println("run");
    }

    static void main() {

        MyClass m = null;
        MyClass<A> m2 = null;

        m2 = m;
        m = m2;


        List<?>[] list;
        superAdd(new ArrayList<A>());
        SuperEx.<B>run(new B());
    }

    private static void superAdd(List<?> list) {
        Object o = list.getFirst();
    }

}
