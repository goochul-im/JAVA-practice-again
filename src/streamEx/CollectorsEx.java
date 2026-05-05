package streamEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsEx {

    private static class Person{
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {

        ex2();
    }

    private static void ex3() {
        IntStream intStream = new Random().ints(10, 1, 11);

        Stream<Integer> boxed = intStream.boxed();

//        Comparator<String> comparator = (String str1, String str2) -> str1.equals(str2);

    }

    private static void ex2() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, "민수"));
        people.add(new Person(2, "영희"));
        people.add(new Person(3, "철수"));

        String collect = people.stream()
                .map(person -> person.name)
                .collect(Collectors.joining(","));

        System.out.println(collect);

    }

    private static void ex1() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, "민수"));
        people.add(new Person(2, "영희"));
        people.add(new Person(3, "철수"));

        Map<Integer, Person> collect = people.stream()
                .collect(Collectors.toMap(p -> p.id, p -> p));


        Person[] array = people.stream()
                .toArray(Person[]::new);
    }

}
