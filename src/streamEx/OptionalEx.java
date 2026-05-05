package streamEx;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {
        ex2();
    }

    private static void ex2() {
        String str = null;

        if (str != null) {
            System.out.println(str);
        }

        if (Optional.ofNullable(str).isPresent()) {
            System.out.println(str);
        }

        Optional.ofNullable(str).ifPresent(System.out::println);

    }

    private static void Ex1() {
        String str = "abc";

        Optional<String> optVal1 = Optional.of(str);
        Optional<String> optVal3 = Optional.of(new String("abc"));
        Optional<String> optValNull = Optional.of(null); //NPE
        Optional<String> optVal4 = Optional.ofNullable(null);

        Optional<String> empty = Optional.<String>empty();

        Optional<String> optVal2 = Optional.of("abc");
        System.out.println(optVal2.get());
        System.out.println(optVal2.orElse("NO")); //null이면 "NO" 반환
        System.out.println(optVal2.orElseGet(String::new)); //null이면 새로운 String 객체 만들어서 반환
        System.out.println(optVal2.orElseThrow(RuntimeException::new)); // null이면 RuntimeException 던짐
    }

}
