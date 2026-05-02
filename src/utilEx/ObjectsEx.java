package utilEx;

import java.util.Objects;

public class ObjectsEx {

    public static void main(String[] args) {

        System.out.println(Objects.deepEquals(null, null));
        System.out.println(Objects.deepEquals(null, 10));

        System.out.println(Objects.toString(null));

        String[] s1 = {"string"};
        String[] s2 = {"string"};

        System.out.println(Objects.equals(s1, s2)); //false, 서로 다른 배열 참조
        System.out.println(Objects.deepEquals(s1, s2)); //true, 배열 내용 같음
    }

}
