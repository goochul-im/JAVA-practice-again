package lambdaEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceEx {

    public static void main(String[] args) {

        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + " ");
        UnaryOperator<Integer> f = i -> i / 10 * 10;
        Predicate<Integer> p = i -> i % 2 == 0;
        Predicate<Integer> negate = p.negate();
        Predicate<Integer> cond1 = i -> i > 100;
        Predicate<Integer> cond2 = i -> i <= 200;

        Predicate<Integer> compCond = negate.and(cond1.or(cond2));

        Predicate<String> hi = Predicate.isEqual("hi");
        boolean hello = hi.test("hello");

        boolean test = Predicate.isEqual("hi").test("hello");


        ArrayList<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        printEvenNumber(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
        printNumber(p, c, list);
        printNumber(negate, c, list);
    }

    static <T> List<T> doSomething(UnaryOperator<T> f, List<T> list) {
        ArrayList<T> newList = new ArrayList<>(list.size());

        for (T t : list) {
            newList.add(f.apply(t));
        }

        return newList;
    }

    static <T> void printEvenNumber(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T t : list) {
            if (p.test(t)) {
                c.accept(t);
            }
        }
        System.out.println("]");
    }

    static <T> void printNumber(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T t : list) {
            if (p.test(t)) {
                c.accept(t);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }


}
