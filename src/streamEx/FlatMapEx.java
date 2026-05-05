package streamEx;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapEx {

    public static void main(String[] args) {
        Stream<String[]> stream = Stream.of(
                new String[]{"abc", "def", "efg"},
                new String[]{"ㄱㄴㄷ", "ㄹㅁㅂ", "ㅅㅇㅈ"}
        );

        Stream<String> flatStream = stream.flatMap(Arrays::stream);

        flatStream.forEach(System.out::println);
    }

}
