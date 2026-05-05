package StringEx;

import java.util.StringJoiner;

public class JoinEX {

    public static void main(String[] args) {

        String[] arr = {"john", "doe", "amy"};

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");

        for (String s : arr) {
            stringJoiner.add(s);
        }

        System.out.println(stringJoiner);

    }

}
