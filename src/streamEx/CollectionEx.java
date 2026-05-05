package streamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionEx {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Random random = new Random();
        IntStream intStream = random.ints();
        intStream.limit(5).forEach(System.out::println);

        IntStream range1 = IntStream.range(1, 5);// 1,2,3,4
        IntStream range2 = IntStream.rangeClosed(1, 5);// 1,2,3,4,5

        Stream<String> str = Stream.of("hi");
        str.sorted(
                Comparator.comparing(String::length)
        );

        Comparator<String> c = (o1, o2) -> {
            return Integer.compare(o2.length(), o1.length());
        };
    }

}
